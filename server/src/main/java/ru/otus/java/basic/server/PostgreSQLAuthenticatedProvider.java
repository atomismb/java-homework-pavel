package ru.otus.java.basic.server;

import java.sql.*;

public class PostgreSQLAuthenticatedProvider implements AuthenticatedProvider {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/otus";
    private static final String DATABASE_USER = "atom";
    private static final String DATABASE_PASSWORD = "mypass";

    private Connection connection;
    private Server server;

    public PostgreSQLAuthenticatedProvider(Server server) {
        this.server = server;
        initializeDatabase();
        System.out.println("PostgreSQL провайдер запущен");
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Подключились к PostgreSQL");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД: " + e.getMessage());
            throw new RuntimeException("Не удалось подключиться к БД");
        }
    }

    private String getUsernameByLoginAndPassword(String login, String password) {
        String query = "SELECT username FROM users WHERE login = ? AND password = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("username");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getUserRoleByLoginAndPassword(String login, String password) {
        String query = "SELECT role FROM users WHERE login = ? AND password = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isLoginAlreadyExists(String login) {
        String query = "SELECT COUNT(*) FROM users WHERE login = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isUsernameAlreadyExists(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String role = getUserRoleByLoginAndPassword(login, password);
        String authUsername = getUsernameByLoginAndPassword(login, password);

        if (authUsername == null) {
            clientHandler.sendMsg("Неправильный логин/пароль");
            return false;
        }

        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Учетная запись уже используется");
            return false;
        }

        clientHandler.setUsername(authUsername);
        clientHandler.setRole(role);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);
        return true;
    }

    @Override
    public boolean register(ClientHandler clientHandler, String login, String password, String username) {
        String role = "user";

        if (login.length() < 3) {
            clientHandler.sendMsg("Логин должен быть минимум 3 символа");
            return false;
        }

        if (!login.toLowerCase().matches("[a-z]+")) {
            clientHandler.sendMsg("Логин только латинские буквы");
            return false;
        }

        if (password.length() < 3) {
            clientHandler.sendMsg("Пароль должен быть минимум 3 символа");
            return false;
        }

        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMsg("Логин уже занят");
            return false;
        }

        if (isUsernameAlreadyExists(username)) {
            clientHandler.sendMsg("Имя пользователя занято");
            return false;
        }

        String insertQuery = "INSERT INTO users (login, password, username, role) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, username);
            ps.setString(4, role);
            ps.executeUpdate();

            clientHandler.setUsername(username);
            clientHandler.setRole(role);
            server.subscribe(clientHandler);
            clientHandler.sendMsg("/regok " + username);
            return true;

        } catch (SQLException e) {
            clientHandler.sendMsg("Ошибка регистрации");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void closeConnection() {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}