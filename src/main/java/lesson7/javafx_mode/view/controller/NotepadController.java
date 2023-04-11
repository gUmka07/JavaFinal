package lesson7.javafx_mode.view.controller;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lesson7.javafx_mode.model.Note;
import lesson7.javafx_mode.presenter.Presenter;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotepadController extends Controller implements Initializable {

    public Button btn_deleteSelected;
    public Button btn_saveNote;
    public Button btn_showText;
    public Button btn_refreshRow;
    Logger logger = Logger.getLogger(NotepadController.class.toString());

    public TextArea textArea;
    public Button btn_addRow;
    public Button btn_clearArea;
    public Button btn_clearNote;

    @FXML
    public TableView<Note> table;

    @FXML
    public TableColumn<Note, String> rows;

    private String idOfRefreshingNote;

    private final Presenter presenter = Presenter.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.textProperty().addListener(this::onTextAreaInput);
        rows.setCellValueFactory(new PropertyValueFactory<Note, String>("content"));
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btn_showText.setDisable(false);
                btn_deleteSelected.setDisable(false);
            }
        });
    }

    public void onTextAreaInput(ObservableValue<? extends String> obs, String old, String niu) {
        btn_addRow.setDisable(obs.getValue().isBlank());
        btn_clearArea.setDisable(obs.getValue().isBlank());
    }

    public void onSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите путь для сохранения");
        fileChooser.setInitialDirectory(new File(DEFAULT_PATH));
        fileChooser.setInitialFileName(DEFAULT_NAME);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Текстовые файлы", "*.txt"));

        File file = fileChooser.showSaveDialog(Objects.requireNonNull(StageHolder.getInstance().getStages().get("MainController"), "Не указан stage"));
        if (file != null) {
            setFilePath(file.getParent());
            setFileName(file.getName());

            presenter.createFile(getFilePath(), getFileName());
            presenter.write(getFilePath(), getFileName(), table.getItems().stream().toList());

            logger.log(Level.INFO, "File created: " + getFilePath() + "/" + getFileName());

            Stage mainControllerStage = StageHolder.getInstance().getStages().get("MainController");
            Stage stage = StageHolder.getInstance().getStages().get("NotepadController");

            if (mainControllerStage != null) {
                stage.close();
                mainControllerStage.show();
            }
        }
    }

    public void addRow(MouseEvent mouseEvent) {
        table.getItems().add(new Note(textArea.getText()));
        textArea.clear();
    }

    public void changeRow(MouseEvent mouseEvent) {
        Note selectedItem = table.getSelectionModel().getSelectedItem();
        textArea.setText(selectedItem.getContent());
        idOfRefreshingNote = selectedItem.getId();

        btn_addRow.setDisable(true);
        btn_refreshRow.setDisable(false);
    }

    public void updateRow(MouseEvent mouseEvent) {
        for (int i = 0; i < table.getItems().size(); i++) {
            Note note = table.getItems().get(i);
            if (note.getId().equals(idOfRefreshingNote)) {
                note.setContent(textArea.getText());
                textArea.clear();
                idOfRefreshingNote = null;
                table.refresh();
                btn_refreshRow.setDisable(true);
                table.getSelectionModel().clearSelection();

                break;
            }
        }
    }

    public void deleteRow(MouseEvent mouseEvent) {
        Note selectedItem = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selectedItem);
        table.getSelectionModel().clearSelection();
        btn_deleteSelected.setDisable(false);
        table.refresh();
    }

    public void clearText(MouseEvent mouseEvent) {
        textArea.clear();
    }

    public void loadFile() {
        List<Note> notes = presenter.open(getFilePath(), getFileName());
        Stage stage = StageHolder.getInstance().getStages().get("NotepadController");
        stage.setTitle(getFileName());
        table.getItems().addAll(notes);
    }
}
