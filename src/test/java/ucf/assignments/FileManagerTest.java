package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FileManagerTest extends TodoListManager{

    @FXML
    private TableView<Item> tableView;
    public final ObservableList<Item> dataList = FXCollections.observableArrayList();


    @Test
    @FXML
    void fileChooser() {
        FileManager.fileChooser();
    }

    @Test
    void openFileLoadData() {
        FileManager.openFileLoadData("C:\\Users\\Jose\\IdeaProjects\\Application part 2\\scratch\\testFile", tableView, dataList);
    }

    @Test
    void getDataFromFile() {
        ArrayList<String> fileData = new ArrayList<>();

        fileData.add("no,   Final Exam CDA 3103,  2021-08-01, no");
        fileData.add("Programming Assignment CIS 3360,  2021-07-24");
        fileData.add(" yes,   cop 3330 exam,  2021-08-06");

        assertEquals(fileData,FileManager.getDataFromFile("C:\\Users\\Jose\\IdeaProjects\\Application part 2\\scratch\\testFile"));
    }

    @Test
    void readFile() {
    }

    @Test
    void openFileSaveData() {
    }

    @Test
    void getDataFromTableView() {
    }
}