package lesson7.javafx_mode.utils;

import lesson7.javafx_mode.model.Note;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс со статическими методами для работы с файлами
 */
public class FileUtils {

    public static List<Note> read(String filePath) throws IOException {
        List<Note> data = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(new Note(line));
            }
        }
        return data;
    }

    public static void createFile(String filePath) throws IOException{
        File file = new File(filePath);

        if (file.exists()) {
            throw new IOException("ОШИБКА: Файл с таким именем уже существует.");
        }

        boolean created = file.createNewFile();

        if (!created) {
            throw new IOException("ОШИБКА: Не удалось создать файл.");
        }
    }

    public static void createFolder(String folderPath) throws IOException{
        File folder = new File(folderPath);

        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IOException("ОШИБКА: Не удалось создать папку.");
            }
        }
    }
}
