package project.mvc;

import project.mvc.controller.LibraryReader;
import project.mvc.model.LibraryBookModel;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryView{
    public void printLibrary(String option, String keyword) throws IOException {
        LibraryReader read = new LibraryReader();
        ArrayList<String> booksFromSearch = read.searchAndReturn(keyword);
        if(booksFromSearch.isEmpty()){
            System.out.println("Sorry! You don't have this book in your Library.");
            System.out.println();
        }
        else {
            System.out.println("You Have -> ");
            booksFromSearch.forEach(System.out::print);
            System.out.println();
        }
    }
}