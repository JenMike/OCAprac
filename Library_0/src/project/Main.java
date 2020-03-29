package project;

import project.mvc.LibraryController;
import project.mvc.LibraryView;
import project.mvc.MyLibraryModel;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a search word: ");
        String keyword = sc.next();
        System.out.println("Option: ");
        String option = sc.next();
        MyLibraryModel model = returnBooksInLibrary(option, keyword); // -t  -a -s -f
        LibraryView view = new LibraryView();
        LibraryController controller = new LibraryController(model, view);

        controller.renderView();

    }
    private static MyLibraryModel returnBooksInLibrary(String option, String keyword){
        MyLibraryModel model = new MyLibraryModel();
        model.setOption(option);
        model.setKeyword(keyword);
        return model;
    }
}