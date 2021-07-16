package ucf.assignments;


public class Item {

    public String done;
    public String description;
    public String dueDate;


    public Item(String done, String description, String dueDate) {
        this.done = done;
        this.description = description;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}


