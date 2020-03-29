package project.mvc;

import project.mvc.controller.LibraryReader;
import project.mvc.model.LibraryBookModel;

import java.util.List;

public class LibraryView{
    public void printLibrary(String option, String keyword){
        LibraryReader read = new LibraryReader();
        System.out.println("You Have -> " + read.searchAndReturn(keyword));
    }
}