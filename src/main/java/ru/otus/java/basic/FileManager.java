package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {

    public String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                content.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
            }
        }
        return content.toString();
    }

    public void writeToFile(String fileName, String text, boolean append) throws IOException {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, append))) {
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
            out.flush();
        }
    }

    public boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public String[] getTextFiles() {
        File currentDir = new File(".");
        File[] files = currentDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files == null) {
            return new String[0];
        }
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }
        return fileNames;
    }
}
