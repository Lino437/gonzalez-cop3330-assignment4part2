package ucf.assignments;

import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileManager {

    // lookup a .txt file location, and return its absolute path
    // using JavaFX FileChooser
    public static String fileChooser() {
        // open .txt file
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
        File file = fc.showOpenDialog(null);
        String absolutePath = null;


        if (file != null) {
            absolutePath = file.getAbsolutePath();
        }

        return absolutePath;
    }

    // open a File and Load data in file
    public static void openFileLoadData(String absolutePath, TableView<Item> tableView) {
        ArrayList<String> arrList = getDataFromFile(absolutePath);

        // Creates an Item and adds it to the Table
        for (int i = 0; i < arrList.size(); i+=3) {
            Item newItem = new Item(arrList.get(i),
                                    arrList.get(i + 1),
                                    LocalDate.parse(arrList.get(i + 2).replace(" ", "")));
            tableView.getItems().add(newItem);
        }
    }

    //Format the data on a ArrayList
    public static ArrayList<String> getDataFromFile(String absolutePath) {
        ArrayList<String> dataList = readFile(absolutePath);
        ArrayList<String> dataListFinal = new ArrayList<>();

        // Given an ArrayList Format to another ArrayList
        for (int i = 0; i < dataList.size(); i++) {
            String[] res = dataList.get(i).split("[,]", 0);
            for (int j = 0; j < res.length; j++) {
                if (!res[j].equals(" ")) {
                    dataListFinal.add(res[j]);
                }
            }
        }
        return dataListFinal;
    }

    // This method read from a file and returns an arrayList
    public static ArrayList<String> readFile(String absolutePath) {
        ArrayList<String> dataList = new ArrayList<>();
        // open file and store data on array list
        try {
            File myObj = new File(absolutePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String str = myReader.nextLine();
                dataList.add(str);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dataList;
    }

    // This method writes to a .txt file with a path
    public static void openFileSaveData(String absolutePath, TableView<Item> tableView) {
        try {
            // opening file
            Writer fileWriter = new FileWriter(absolutePath);
            List<List<String>> arrList = getDataFromTableView(tableView);

            // writing to file
            for (List<String> strings : arrList) {
                for (String string : strings) {
                    fileWriter.write(string + ", ");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // get data from tableView
    public static List<List<String>> getDataFromTableView(TableView tableView) {
        Item item;
        List<List<String>> arrList = new ArrayList<>();

        // getting data from tableView
        for (int i = 0; i < tableView.getItems().size(); i++) {
            item = (Item) tableView.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(item.getDone());
            arrList.get(i).add(item.getDescription());
            arrList.get(i).add(item.getDueDate().toString());
        }
        return arrList;
    }
}
