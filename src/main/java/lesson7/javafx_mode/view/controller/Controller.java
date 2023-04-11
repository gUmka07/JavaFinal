package lesson7.javafx_mode.view.controller;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller {

    public static final String DEFAULT_PATH = "C://";
    public static final String DEFAULT_NAME = "note";

    private String filePath;

    private String fileName;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
