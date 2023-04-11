package lesson7.javafx_mode.view.controller;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StageHolder {

    private Map<String, Stage> stages;

    private static StageHolder INSTANCE;

    private StageHolder(){}

    public static StageHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StageHolder();
        }

        return INSTANCE;
    }


    public Map<String, Stage> addStage(String controllerName, Stage stage) {
        getStages().put(controllerName, stage);

        return this.stages;
    }

    public Map<String, Stage> getStages() {
        if (stages == null) {
            stages = new HashMap<>();
        }
        return stages;
    }
}
