package ru.otus.java.basic.application;

import ru.otus.java.basic.HttpRequest;
import ru.otus.java.basic.processors.RequestProcessor;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class DeleteItemsProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        ItemsStorage.deleteItem(id);

        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain\r\n" +
                "\r\n" +
                "OK";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
