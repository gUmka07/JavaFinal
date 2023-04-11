package lesson7.javafx_mode.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lesson7.javafx_mode.view.controller.Controller;
import lesson7.javafx_mode.view.controller.StageHolder;

import java.util.Objects;

// Запускать из javafx_mode.Main
public class JavaFXViewLauncher extends Application {

    public static void launchApplicationView(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String packagePath = getClass().getPackageName().replaceAll("\\.", "/");
        String mainScenePath = packagePath + "/fxml/scene_main.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource(mainScenePath),
                "Не удалось найти форму по указанному пути: " + mainScenePath));
        Parent root = fxmlLoader.load();
        stage.setTitle("Lesson 7");
        stage.setScene(new Scene(root));

        StageHolder.getInstance().addStage(fxmlLoader.getController().getClass().getSimpleName(), stage);

        stage.show();


    }
}
