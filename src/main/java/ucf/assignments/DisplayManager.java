package ucf.assignments;

import javafx.collections.ObservableList;

public class DisplayManager {

    // get all completed items
    public static ObservableList<Item> getAll(ObservableList<Item> allItems, ObservableList<Item> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getDone().equals("yes") || dataList.get(i).getDone().equals("no")) {
                allItems.add(dataList.get(i));
            }
        }
        return allItems;
    }

    // get all completed items
    public static ObservableList<Item> getCompleted(ObservableList<Item> allItems, ObservableList<Item> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getDone().equals("yes")) {
                allItems.add(dataList.get(i));
            }
        }
        return allItems;
    }

    // get all uncompleted items
    public static ObservableList<Item> getUncompleted(ObservableList<Item> allItems, ObservableList<Item> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getDone().equals("no")) {
                allItems.add(dataList.get(i));
            }
        }
        return allItems;
    }

}
