package ru.otus.java.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;
    private ExecutorService threadPool;
    private Logger logger = LogManager.getLogger(HttpServer.class);

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
        this.threadPool = Executors.newFixedThreadPool(10);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Сервер запущен на порту: " + port);
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    threadPool.execute(() -> {
                        try (Socket clientSocket = socket) {
                            byte[] buffer = new byte[8192];
                            int n = clientSocket.getInputStream().read(buffer);
                            if (n < 1) {
                                return;
                            }
                            String rawRequest = new String(buffer, 0, n);
                            HttpRequest request = new HttpRequest(rawRequest);
                            dispatcher.execute(request, clientSocket.getOutputStream());
                        } catch (IOException e) {
                            logger.error("Ошибка при обработке подключения: ", e);
                        }
                    });

                } catch (IOException e) {
                    logger.error("Ошибка при подключении клиента: ", e);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка запуска сервера: ", e);
        }
    }
}

