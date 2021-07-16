package ucf.assignments;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class ConditionsManager {
    // confirmation to clear all items
    public static boolean isClear() {
        boolean clear = false;
        // Confirmation alert to clear items on the the list
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Clear Table");
        alert.setHeaderText("Are you sure you want to delete all items?");
        // to cancel clear items
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(cancelButtonType);
        // to accept clearing all items
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            clear = true;
        }
        return clear;
    }

    // validate Done function to "yes" or "no" value
    public static boolean validateDone(String done) {
        return !done.equals("yes") && !done.equals("no");
    }

    // validate description to length between 1 and 256 characters
    public static boolean validateDescription(String description) {
        return description.length() > 256 || description.length() < 1;
    }

    // validate Due Date to format YYYY-MM-DD and valid within Gregorian Calendar
    public static boolean validateDate(String strDate) {
        // Check if date is 'null'
        if (!strDate.trim().equals("")) {
            //Set date format to yyyy-MM-dd
            SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
            sdfrmt.setLenient(false);
            // Create Date object & parse the string into date
            try {
                Date javaDate = sdfrmt.parse(strDate);
                return false;
            } catch (ParseException e) {
                return true;
            }
        }
        return true;
    }


}
