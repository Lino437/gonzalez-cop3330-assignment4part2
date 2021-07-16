/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  *  Copyright 2021 Jose Gonzalez
 *
 * The application shall manage a single list of items
The list shall have the capacity to store at least 100 unique items

An item shall have a description
A description shall be between 1 and 256 characters in length
An item shall have a due date
A due date shall be a valid date within the Gregorian Calendar
A due date shall be displayed to users in the format: YYYY-MM-DD

A user shall be able to add a new item to the list
A user shall be able to remove an item from the list
A user shall be able to clear the list of all items
A user shall be able to edit the description of an item within the list
A user shall be able to edit the due date of an item within the list
A user shall be able to mark an item in the list as either complete or incomplete
A user shall be able to display all of the existing items in the list
A user shall be able to display only the incomplete items in the list
A user shall be able to display only the completed items in the list

A user shall be able to save the list (and all of its items) to external storage
A user shall be able to load a list (and all of its items) from external storage

The developer shall provide a help screen with directions on how to use the application.
    The help screen shall describe how to execute each behavioral requirement provided by the application (e.g. add an item,
     remove an item, edit an item, etc)
    The help screen shall include a dedication to "Rey"
    This help screen shall be provided as either a dedicated window within the application, or a markdown file called `readme.md`
      on your GitHub repository for the project.)
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TodoController implements Initializable {

    // configure the table
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> doneColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, String> dueDateColumn;

    // variable for new Item Object
    @FXML
    private TextField descriptionTextField;
    @FXML
    private DatePicker dueDateDatePicker;
    @FXML
    public final ObservableList<Item> dataList = FXCollections.observableArrayList();

    // This method allow the user to edit the description for an Item
    @FXML
    public void changeDescriptionCellEvent(TableColumn.CellEditEvent editedCell) {
        // if description entered does not meet condition, pop alert
        if (ConditionsManager.validateDescription(editedCell.getNewValue().toString())) {
            AlertManager.alertDescription();
        } else {
            Item itemSelected = tableView.getSelectionModel().getSelectedItem();
            dataList.remove(itemSelected);

            itemSelected.setDescription(editedCell.getNewValue().toString());
            dataList.add(itemSelected);
        }
    }

    // This method allow the user to edit the due Date for an Item
    @FXML
    public void changeDueDateCellEvent(TableColumn.CellEditEvent editedCell) {
        // if due date entered does not meet condition, pop alert
        if (ConditionsManager.validateDate(editedCell.getNewValue().toString())) {
            AlertManager.alertDueDate();
        }
        // store updated item on data list and display to tableview
        else {
            Item itemSelected = tableView.getSelectionModel().getSelectedItem();
            dataList.remove(itemSelected);

            itemSelected.setDueDate(editedCell.getNewValue().toString());
            dataList.add(itemSelected);
        }
    }

    // This method allow the user to edit the completed value for an Item
    @FXML
    public void changeDoneCellEvent(TableColumn.CellEditEvent editedCell) {
        // if done cell does not meet conditions pop alert
        if (ConditionsManager.validateDone(editedCell.getNewValue().toString())) {
            AlertManager.alertDone();
        } else {
            Item itemSelected = tableView.getSelectionModel().getSelectedItem();
            dataList.remove(itemSelected);

            itemSelected.setDone(editedCell.getNewValue().toString());
            dataList.add(itemSelected);
        }
    }

    // get all items and display those to tableview
    @FXML
    public void displayAllClicked(ActionEvent actionEvent) {
        // empty table
        ObservableList<Item> allItems;
        allItems = tableView.getItems();
        allItems.remove(0, allItems.size());

        // get all items from dataList and display those to tableview
        DisplayManager.getAll(allItems, dataList);
    }

    // get Completed items and display those to tableview
    @FXML
    public void displayCompletedClicked(ActionEvent actionEvent) {
        // empty table
        ObservableList<Item> selectedRows, allItems;
        allItems = tableView.getItems();
        allItems.remove(0, allItems.size());

        // get completed items from dataList and display those to tableview
        DisplayManager.getCompleted(allItems, dataList);
    }

    // get Uncompleted items and display those
    @FXML
    public void displayUncompletedClicked(ActionEvent actionEvent) {
        // empty table
        ObservableList<Item> selectedRows, allItems;
        allItems = tableView.getItems();
        allItems.remove(0, allItems.size());

        // get Uncompleted items and display to tableview
        DisplayManager.getUncompleted(allItems, dataList);
    }

    // open Information Window with help info
    @FXML
    public void helpButtonClicked(ActionEvent actionEvent) {
        AlertManager.alertHelp();
    }

    // load a file to the tableView
    @FXML
    public void loadItemClicked(ActionEvent actionEvent) {
        // get file path to load
        String absolutePath = FileManager.fileChooser();

        // load file data on Table
        FileManager.openFileLoadData(absolutePath, tableView, dataList);
    }

    // save all items on the table to .txt file, to a location selected by user.
    @FXML
    public void saveItemClicked(ActionEvent actionEvent) {
        // look for file absolute path
        String absolutePath = FileManager.fileChooser();
        // open file with file path and store data on the table
        FileManager.openFileSaveData(absolutePath, tableView);
    }

    // once clicked it will clear all items on the screen
    @FXML
    public void clearButtonClear(ActionEvent actionEvent) {
        // get items on the table
        ObservableList<Item> selectedRows, allItems;
        allItems = tableView.getItems();

        // if confirm delete all items on the table
        if (ConditionsManager.isClear()) {
            allItems.remove(0, allItems.size());
            dataList.remove(0, dataList.size());
        }
    }

    // This method will remove the selected table row
    @FXML
    public void deleteButtonPushed() {
        ObservableList<Item> allItems;
        allItems = tableView.getItems();

        // delete selected item
        Item item = tableView.getSelectionModel().getSelectedItem();
        allItems.remove(item);
        dataList.remove(item);
    }

    // This method will create a new Item object and added it to the table
    @FXML
    public void newItemButtonPushed() {
        if (ConditionsManager.validateDescription(descriptionTextField.getText())) {
            AlertManager.alertDescription();
        } else if (dueDateDatePicker.getValue() == null) {
            AlertManager.alertDueDate();
        } else {
            Item newItem = new Item("no",
                    descriptionTextField.getText(),
                    dueDateDatePicker.getValue().toString());

            descriptionTextField.setText("");
            dueDateDatePicker.setValue(LocalDate.now());

            // get all the items from the table list, then add the new Item
            dataList.add(newItem);
            tableView.getItems().add(newItem);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set up the columns in the table
        doneColumn.setCellValueFactory(new PropertyValueFactory<>("done"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        // load data
        tableView.setItems(getPeople());

        // Allowing description and to be editable
        tableView.setEditable(true);
        doneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // This allows the multiple rows to be selected
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    // This method will return an ObservableList of Item objects
    @FXML
    public ObservableList<Item> getPeople() {
        ObservableList<Item> item = FXCollections.observableArrayList();
        item.add(new Item("yes", "this is an example", "2021-07-15"));
        dataList.add(new Item("yes", "this is an example", "2021-07-15"));
        return item;
    }
}