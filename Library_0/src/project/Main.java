package project;

//import org.jetbrains.annotations.NotNull;

import project.mvc.LibraryController;
import project.mvc.LibraryView;
import project.mvc.MyLibraryModel;

public class Main{
    public static void main(String[] args) {
        MyLibraryModel model = returnBooksInLibrary(args[0], args[1]);
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