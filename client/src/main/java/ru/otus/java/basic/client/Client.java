package ru.otus.java.basic.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean connected = true;

    public Client() {
        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (connected && !socket.isClosed()) {
                        String message = in.readUTF();
                        if (message.startsWith("/")) {
                            if (message.startsWith("/exitok")) {
                                System.out.println("Отключение от сервера...");
                                break;
                            }
                            if (message.startsWith("/authok ")) {
                                System.out.println("Удалось успешно войти в чат под именем пользователя " + message.split(" ")[1]);
                            }
                            if (message.startsWith("/regok ")) {
                                System.out.println("Удалось успешно пройти регистрацию под ником " + message.split(" ")[1]);
                            }

                        } else {
                            System.out.println(message);
                        }
                    }
                } catch (IOException e) {
                    if (connected) {
                        System.out.println("Соединение с сервером разорвано");
                    }
                } finally {
                    disconnect();
                }
            }).start();

            while (connected && !socket.isClosed()) {
                String message = sc.nextLine();
                try {
                    out.writeUTF(message);
                    if (message.startsWith("/exit")) {
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Не удалось отправить сообщение. Соединение разорвано.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к серверу: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        connected = false;
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
        }
    }
}