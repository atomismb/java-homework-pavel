package ru.otus.java.basic.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;

    private List<ClientHandler> clients;
    private AuthenticatedProvider authenticatedProvider;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
        authenticatedProvider = new InMemoryAuthenticatedProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запустился на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        System.out.println("Клиент " + clientHandler.getUsername() + " отключился");
        clients.remove(clientHandler);
    }

    public void broadcastMessage(String username, String message) {
        for (ClientHandler c : clients) {
            c.sendMsg(ConsoleColors.CYAN_BOLD + username + ": " + ConsoleColors.RESET + message);
        }
    }

    public boolean isUsernameBusy(String username) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public AuthenticatedProvider getAuthenticatedProvider() {
        return authenticatedProvider;
    }

    public boolean privateMessage(String fromUser, String toUser, String message) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(toUser)) {
                client.sendMsg(ConsoleColors.PURPLE_BOLD + "Личное сообщение от " + ConsoleColors.RESET
                        + ConsoleColors.BLUE_BOLD + fromUser + ConsoleColors.RESET + ": " + message);
                return true;
            }
        }
        return false;
    }

    public boolean kickUser(String adminUsername, String targetUsername) {
        if (!"admin".equalsIgnoreCase(adminUsername)) {
            return false;
        }

        if (adminUsername.equalsIgnoreCase(targetUsername)) {
            return false;
        }

        for (ClientHandler client : clients) {
            if (targetUsername.equalsIgnoreCase(client.getUsername())) {
                unsubscribe(client);
                client.sendMsg("Вы были удалены администратором");
                client.sendMsg("/exitok");
                client.disconnect();
                return true;
            }
        }
        return false;
    }
}
