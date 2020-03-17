package project.mvc;

import project.mvc.functionality.*;

public class LibraryView{
    public void printLibrary(String option, String keyword){
        LibraryReader reader = new LibraryReader();
        System.out.println("You Have -> " + reader.searchAndReturn(keyword));
    }
}