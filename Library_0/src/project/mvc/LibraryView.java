package project.mvc;

import project.mvc.controller.LibraryReader;
import project.mvc.model.LibraryBookModel;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibraryView{
    public String key;
    public String option;

    public void printLibrary(String option, String keyword) throws IOException {
        LibraryReader read = new LibraryReader();
        ArrayList<String> booksFromSearch = read.searchAndReturn(option, keyword);
        if(booksFromSearch.isEmpty()){
            System.out.println("You don't have this item in your Library.");
            System.out.println();
        }
        else {
            System.out.println("You Have -> ");
            booksFromSearch.forEach(System.out::print);
            System.out.println();
        }
    }
    public void setOutputText(Scanner sc){
        System.out.println("Enter a keyword to search or Q to terminate: ");
        this.key = sc.next();
        if(!key.equals("Q")) {
            System.out.println("Choose one of the following options to search by");
            System.out.println("\"-t\" for title");
            System.out.println("\"-a\" for author");
            System.out.println("\"-s\" for SKU");
            System.out.println("\"-f\" for format");
            System.out.println("\"-u\" for uncertain");
            System.out.println("Option: ");
            this.option = sc.next();
        }
    }
}