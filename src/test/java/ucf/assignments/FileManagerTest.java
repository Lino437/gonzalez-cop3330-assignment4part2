package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private TableView<Item> tableView;
    public final ObservableList<Item> dataList = FXCollections.observableArrayList();
    public final File file = new File("output.txt");

    @Test
    void readFile() {
        ArrayList<String> fileData = new ArrayList<>();

        fileData.add("no, gndtdnytdn, 2021-07-29, ");
        fileData.add("no, Some serious stuff, 2021-07-06, ");
        fileData.add("no, pls dont do it, 2021-07-28, ");
        fileData.add("yes, this is yes, 2021-07-21, ");
        fileData.add("yes, this is yes too, 2021-07-22, ");

        ArrayList<String> actual = FileManager.readFile(getAbsolutePath());

        for (int i = 0; i < actual.size(); i++) {
            System.out.println(actual.get(i));
        }

        assertEquals(fileData, actual);
    }

    public String getAbsolutePath() {
        String absolute = "";
        try {
            absolute = file.getAbsolutePath();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return absolute;
    }

}