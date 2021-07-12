package ucf.assignments;

import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class Item {

    public String done;
    public String description;
    public LocalDate dueDate;

    public Item(String done, String description, LocalDate dueDate) {
        this.done = new String(done);
        this.description = new String(description);
        this.dueDate = dueDate;
    }

    public Item() {

    }



    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate() {
        this.dueDate = dueDate;
    }
}
