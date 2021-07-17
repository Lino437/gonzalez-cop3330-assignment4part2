package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayManagerTest {

    @Test
    void getAll() {
        ObservableList<Item> allItems = FXCollections.observableArrayList();
        ObservableList<Item> dataList = FXCollections.observableArrayList();


        dataList.add(new Item("yes", "This is a text", "2021-07-16"));
        dataList.add(new Item("no", "This is a text", "2018-05-20"));
        dataList.add(new Item("no", "This is a text", "2015-01-12"));
        dataList.add(new Item("yes", "This is a text", "2012-02-28"));
        dataList.add(new Item("yes", "This is a text", "1954-06-16"));

        assertEquals(allItems, DisplayManager.getAll(allItems,dataList));
    }

    @Test
    void getCompleted() {
        ObservableList<Item> allItems = FXCollections.observableArrayList();
        ObservableList<Item> dataList = FXCollections.observableArrayList();

        allItems.add(new Item("yes", "This is a text", "2021-07-16"));
        allItems.add(new Item("yes", "This is a text", "2012-02-28"));
        allItems.add(new Item("yes", "This is a text", "1954-06-16"));

        dataList.add(new Item("yes", "This is a text", "2021-07-16"));
        dataList.add(new Item("no", "This is a text", "2018-05-20"));
        dataList.add(new Item("no", "This is a text", "2015-01-12"));
        dataList.add(new Item("yes", "This is a text", "2012-02-28"));
        dataList.add(new Item("yes", "This is a text", "1954-06-16"));

        assertEquals(allItems, DisplayManager.getCompleted(allItems,dataList));
    }

    @Test
    void getUncompleted() {
        ObservableList<Item> allItems = FXCollections.observableArrayList();
        ObservableList<Item> dataList = FXCollections.observableArrayList();

        allItems.add(new Item("no", "This is a text", "2018-05-20"));
        allItems.add(new Item("no", "This is a text", "2015-01-12"));


        dataList.add(new Item("yes", "This is a text", "2021-07-16"));
        dataList.add(new Item("no", "This is a text", "2018-05-20"));
        dataList.add(new Item("no", "This is a text", "2015-01-12"));
        dataList.add(new Item("yes", "This is a text", "2012-02-28"));
        dataList.add(new Item("yes", "This is a text", "1954-06-16"));

        assertEquals(allItems, DisplayManager.getUncompleted(allItems,dataList));
    }
}