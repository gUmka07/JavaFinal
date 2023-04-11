package lesson7.javafx_mode.service;

import lesson7.javafx_mode.model.Note;
import lesson7.javafx_mode.utils.FileUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileService {

    Logger logger = Logger.getLogger(FileService.class.toString());

    private static FileService INSTANCE;

    private FileService() {
    }

    public static FileService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileService();
        }

        return INSTANCE;
    }

    public void create(String folderPath, String fileName) {
        try {
            FileUtils.createFolder(folderPath);
            FileUtils.createFile(folderPath + "/" + fileName);
        } catch (IOException exception) {
            logger.log(Level.INFO, "Не удалось создать файл: " + exception.getMessage());
        }
    }


    public void write(String folderPath, String fileName, List<Note> notes) {
        try {
            FileWriter fileWriter = new FileWriter(folderPath + "/" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Note note : notes) {
                bufferedWriter.write(note.getContent());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException exception) {
            logger.log(Level.INFO, "Не удалось записать в файл: " + exception.getMessage());
        }
    }

    public List<Note> getFileNotes(String folder, String fileName) {
        try {
            return read(folder, fileName);
        } catch (IOException exception) {
            logger.log(Level.INFO, "Не удалось прочитать файл: " + exception.getMessage());
        }

        return new ArrayList<>();
    }

    private List<Note> read(String folderPath, String fileName) throws IOException {
        return FileUtils.read(folderPath + "/" + fileName);
    }
}
