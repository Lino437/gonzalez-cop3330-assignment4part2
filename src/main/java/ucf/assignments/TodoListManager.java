 /*
  *
  *  *  UCF COP3330 Summer 2021 Assignment 4 Solution
  *  *  Copyright 2021 Jose Gonzalez
  *
  */

 package ucf.assignments;

 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;

 import java.io.IOException;
 import java.util.Objects;


 public class TodoListManager extends Application {

     @Override
     public void start(Stage primaryStage) {
         try {
             Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Todo.fxml")));

             Scene scene = new Scene(root);

             primaryStage.setScene(scene);
             primaryStage.setTitle("TodoList");
             primaryStage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
