package lesson7.javafx_mode.view.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController extends Controller implements Initializable {

    public MenuItem create;
    public MenuItem open;
    public MenuItem exit;

    Logger logger = Logger.getLogger(MainController.class.toString());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void onCreate() {
        try {
            onFileChosen(true);
        } catch (IOException exception) {
            logger.log(Level.INFO, "Ошибка при загрузке формы блокнота: " + exception.getMessage());
        }
    }

    public void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");
        fileChooser.setInitialDirectory(new File(DEFAULT_PATH));
        File file = fileChooser.showOpenDialog(Objects.requireNonNull(StageHolder.getInstance().getStages().get("MainController"), "Не указан stage"));
        if (file != null) {
            setFileName(file.getName());
            setFilePath(file.getParent());
            logger.log(Level.INFO, "Chosen file: " + getFilePath() + "/" + getFileName());

            try {
                onFileChosen(false);
            } catch (IOException exception) {
                logger.log(Level.INFO, "Ошибка при загрузке формы блокнота: " + exception.getMessage());
            }
        }
    }

    public void onFileChosen(boolean isNew) throws IOException {
        String packagePath = getClass().getPackageName().replaceAll("\\.", "/").replace("/controller", "/");
        String mainScenePath = packagePath + "fxml/scene_notepad.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource(mainScenePath),
                "Не удалось найти форму по указанному пути: " + mainScenePath));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(getFileName());
        stage.setScene(new Scene(root));


        NotepadController controller = fxmlLoader.getController();
        Map<String, Stage> stages = StageHolder.getInstance().addStage(controller.getClass().getSimpleName(), stage);

        if (!isNew) {
            controller.setFilePath(getFilePath());
            controller.setFileName(getFileName());
            controller.loadFile();
        }

        Stage mainControllerStage = stages.get("MainController");

        if (mainControllerStage != null) {
            mainControllerStage.hide();
            stage.setOnCloseRequest(windowEvent -> {
                stage.close();
                mainControllerStage.show();
            });
            stage.show();
        }

    }
}
