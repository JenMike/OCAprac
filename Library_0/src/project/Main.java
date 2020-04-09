package project;

import project.mvc.LibraryController;
import project.mvc.LibraryView;
import project.mvc.MyLibraryModel;
import project.mvc.SearchThread;
import project.mvc.controller.LibraryReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Type a keyword to search or hold shift and press Q to terminate");

        Scanner sc = new Scanner(System.in);
        String key = sc.next();
  //      LibraryView view = new LibraryView();


        while(!key.equals("Q")){
            SearchThread t1 = new SearchThread(key);
            t1.start();
                                                                                                                                                                                                                                                                                                                                                                                                            t1.join();

//            MyLibraryModel model = buildLibraryModel("t", key);
//            LibraryController controller = new LibraryController(model, view);
//            controller.renderView();
            System.out.println("Type a keyword to search or hold shift and press Q to terminate");
            key = sc.next();
        }

    }
    public static MyLibraryModel buildLibraryModel(String option, String keyword){
        MyLibraryModel model = new MyLibraryModel();
        model.setOption(option);
        model.setKeyword(keyword);
        return model;
    }
}
