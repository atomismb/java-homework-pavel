package ru.otus.java.basic;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HomeWorkPanichenko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует программа \"Простенький калькулятор\"! ");
        System.out.println("Для расчёта введите числа как в примере: 1 + 1");
        System.out.println("Или для выхода из программы введите: exit");
        while (true) {
            try (Socket socket = new Socket("localhost", 8080)) {
                ClientSide client = new ClientSide(
                        socket.getInputStream(),
                        socket.getOutputStream()
                );
                client.getInfo();
                System.out.print("> ");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    client.send(userInput);
                    break;
                }

                client.send(userInput);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
