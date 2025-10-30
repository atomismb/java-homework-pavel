package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {

    public String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            char[] buffer = new char[1024];
            int charsRead;

            while ((charsRead = in.read(buffer)) != -1) {
                content.append(buffer, 0, charsRead);
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
