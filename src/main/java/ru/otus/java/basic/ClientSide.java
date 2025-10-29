package ru.otus.java.basic;

import java.io.*;

public class ClientSide implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public ClientSide(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
            System.out.println();
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }

    }
    public void getInfo() throws IOException{
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }

    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
