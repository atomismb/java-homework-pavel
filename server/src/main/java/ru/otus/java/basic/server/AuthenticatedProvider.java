package ru.otus.java.basic.server;

public interface AuthenticatedProvider {
    boolean authenticate(ClientHandler clientHandler, String login, String password);

    boolean register(ClientHandler clientHandler, String login, String password, String username);

    void closeConnection();
}