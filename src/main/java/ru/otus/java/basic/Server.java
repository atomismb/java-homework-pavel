package ru.otus.java.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер начал свою работу");

            while (true) {
                Socket client = serverSocket.accept();
                try {
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                    dos.writeUTF("Список доступных математических операций: +,-,*,/");
                    dos.flush();

                    String userInput = dis.readUTF();
                    System.out.println("userInput = " + userInput);
                    if (userInput.equalsIgnoreCase("exit")) {
                        System.out.println("клиент разрывает связь");
                        client.close();
                        continue;
                    }

                    String calculationResult = calculate(userInput);
                    if (calculationResult.startsWith("Ошибка")) {
                        dos.writeUTF(calculationResult);
                        System.out.println(calculationResult);
                    } else {
                        String result = "Результат выполнения:\n" + userInput + " = " + calculationResult;
                        dos.writeUTF(result);
                        System.out.println("result = " + result);
                    }
                    client.close();
                } catch (IOException e) {
                    System.out.println("Ошибка соединения с клиентом: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Сервер не поднялся");
        }
    }

    private static String calculate(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return "Ошибка: Вы ничего не ввели для выполнения вычислений";
        }
        String[] math = userInput.split(" ", 3);
        if (math.length < 3) {
            return "Ошибка: Неправильный формат. Используйте: число операция число";
        }
        if (math[1].length() != 1) {
            return "Ошибка: Операция должна быть одним символом (+, -, *, /)";
        }
        char mathOperation = math[1].charAt(0);

        if (mathOperation != '+' && mathOperation != '-' && mathOperation != '*' && mathOperation != '/') {
            return "Ошибка: Неподдерживаемая операция: " + mathOperation;
        }
        try {
            float firstNum = Float.parseFloat(math[0]);
            float secondNum = Float.parseFloat(math[2]);

            if (mathOperation == '/' && secondNum == 0) {
                return "Ошибка: Деление на ноль!";
            }
            float result = 0;
            if (mathOperation == '+') {
                result = firstNum + secondNum;
            } else if (mathOperation == '-') {
                result = firstNum - secondNum;
            } else if (mathOperation == '*') {
                result = firstNum * secondNum;
            } else if (mathOperation == '/') {
                result = firstNum / secondNum;
            }
            System.out.println("Будет произведён расчёт: " + firstNum + " " + mathOperation + " " + secondNum);
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Ошибка: Неправильный формат чисел '" + math[0] + "' или '" + math[2] + "'";
        }
    }
}