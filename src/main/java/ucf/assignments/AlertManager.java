package ucf.assignments;

import javafx.scene.control.Alert;

public class AlertManager {

    // alert for due date
    public static void alertDueDate() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Due Date Validator");
        alert.setHeaderText("Due date format: YYYY-MM-DD\n" +
                "Valid within Gregorian Calendar");

        alert.showAndWait();
    }

    // alert for done property
    public static void alertDone() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Complete Validator");
        alert.setHeaderText("Enter \"yes\" or \"no\"");

        alert.showAndWait();
    }

    // alert for description
    public static void alertDescription() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Text Validator");
        alert.setHeaderText("Text is too long or too short");
        alert.showAndWait();
    }

    // alert for help
    public static void alertHelp() {
        // Open new Window
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setResizable(true);
        alert.setContentText(helpText());
        alert.showAndWait();
    }

    // This is the help String for message
    public static String helpText() {
        String str = "**Help in dedication to Rey**\n" +
                "3 step guide to perform each behavior on the application\n" +
                "\n" +
                "Add Item\n" +
                "1. Fill the boxes below which correspond to each of the attributes( Done, Description, Due Date)\n" +
                "2. Click Button called \"Add New Item\" to include it to the table\n" +
                "3. A new Item should appear on the bottom of the table\n" +
                "\n" +
                "Delete Item\n" +
                "1. Select an item or multiple items to be deleted on the table\n" +
                "2. Click the Button delete to delete Item\n" +
                "3. The deleted Item should be deleted from table\n" +
                "\n" +
                "Clear Item\n" +
                "1. Click the button on the bottom right called \"Clear\"\n" +
                "2. Confirm that you want to clear the table\n" +
                "3. The table should have no contents\n" +
                "\n" +
                "Edit Description\n" +
                "1. Double-click on \"Description\" to be edited\n" +
                "2. Update the description of the Item\n" +
                "3. Click \"enter\" key, the description should be updated\n" +
                "\n" +
                "Edit Due Date\n" +
                "1. Double-click on \"Due Date\" to be edited\n" +
                "2. Update the due date of the Item\n" +
                "3. Click \"enter\" key, the due date should be updated\n" +
                "\n" +
                "Display all Items\n" +
                "1. Click Display on the top left of the page\n" +
                "2. Click all\n" +
                "3. All Items should be displayed on the table\n" +
                "\n" +
                "Display Completed Items\n" +
                "1. Click Display on the top left of the page\n" +
                "2. Click Completed\n" +
                "3. All Items mark as completed should appear on the table\n" +
                "\n" +
                "Display Uncompleted Items\n" +
                "1. Click Display on the top left of the page\n" +
                "2. Click Uncompleted\n" +
                "3. All Items mark as uncompleted should appear on the table\n" +
                "\n" +
                "To see this again\n" +
                "1. Click Help on the top left of the page\n" +
                "2. Click About\n" +
                "3. This file should appear on a new window\n" +
                "\n" +
                "**If Rey has any other questions, please contact:\n" +
                "Christopher.Hollander@ucf.edu or through Webcourses@UCF.**";
        return str;
    }

}
