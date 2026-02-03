package ru.otus.java.basic;

import ru.otus.java.basic.application.ItemsStorage;
public class Application {
    public static void main(String[] args) {
        ItemsStorage.init(); new HttpServer(8189).start();
    }
}

