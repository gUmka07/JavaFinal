package lesson7.javafx_mode.presenter;

import lesson7.javafx_mode.model.Note;
import lesson7.javafx_mode.service.FileService;

import java.util.List;

public final class Presenter {

    private static Presenter INSTANCE;
    private final FileService fileService = FileService.getInstance();


    private Presenter() {
    }

    public static Presenter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Presenter();
        }

        return INSTANCE;
    }

    public void createFile(String folder, String fileName) {
        fileService.create(folder, fileName);
    }

    public void write(String folder, String fileName, List<Note> content) {
        fileService.write(folder, fileName, content);
    }

    public List<Note> open(String folder, String fileName) {
        return fileService.getFileNotes(folder, fileName);
    }

}
