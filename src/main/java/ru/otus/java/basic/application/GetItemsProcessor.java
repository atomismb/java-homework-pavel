package ru.otus.java.basic.application;

import com.google.gson.Gson;
import ru.otus.java.basic.HttpRequest;
import ru.otus.java.basic.processors.RequestProcessor;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetItemsProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        Gson gson = new Gson();
        String idParam = request.getParameter("id");

        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            List<Item> items = ItemsStorage.getItems();
            Item foundItem = null;

            for (Item item : items) {
                if (item.getId().equals(id)) {
                    foundItem = item;
                    break;
                }
            }

            if (foundItem != null) {
                String response = "" +
                        "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: application/json\r\n" +
                        "\r\n" +
                        gson.toJson(foundItem);
                output.write(response.getBytes(StandardCharsets.UTF_8));
            } else {
                String response = "" +
                        "HTTP/1.1 404 Not Found\r\n" +
                        "Content-Type: application/json\r\n" +
                        "\r\n" +
                        "{\"error\":\"Item not found\"}";
                output.write(response.getBytes(StandardCharsets.UTF_8));
            }
        } else {
            String itemsJson = gson.toJson(ItemsStorage.getItems());
            String response = "" +
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n" +
                    itemsJson;
            output.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
}