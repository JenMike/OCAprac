package project;

import project.mvc.*;
import project.mvc.controller.LibraryReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        try {
            createFileIfNotExists();
            System.out.println("Type a keyword to search or Q to terminate");
            Scanner sc = new Scanner(System.in);
            String key = sc.next();
            System.out.println();
            LibraryView view = new LibraryView();
            while (!key.equals("Q")) {
                MyLibraryModel model = buildLibraryModel("t", key);
                LibraryController controller = new LibraryController(model, view);
                controller.renderView();
                System.out.println("Type a keyword to search or Q to terminate");
                key = sc.next();
            }
        } catch (IOException e){
            System.out.println("Error: Something went wrong: " + e.getMessage());
        }
    }
    public static MyLibraryModel buildLibraryModel(String option, String keyword){
        MyLibraryModel model = new MyLibraryModel();
        model.setOption(option);
        model.setKeyword(keyword);
        return model;
    }

    public static void createFileIfNotExists() throws IOException {
        File file = new File("resources/Purchases.csv");
        if (file.createNewFile()) {
            LibraryReader callingBackUp = new LibraryReader();
            System.out.println("Library was not found! New Library Generated to search.");
            System.out.println();
            callingBackUp.backUpLibrary(file);
        }
    }
}
