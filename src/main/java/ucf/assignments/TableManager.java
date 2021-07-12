package ucf.assignments;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TableManager {
    // confirmation to clear all items
    public static boolean isClear() {
        Boolean clear = false;

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Clear Table");
        alert.setHeaderText("Are you sure you want to delete all items?");

        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK ){
            clear = true;
        }
        return clear;
    }
}
