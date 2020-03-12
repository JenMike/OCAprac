package com.library.mvc; //lowercase package names

import java.io.File;
import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class AbstractLibraryClass{

    protected File file = new File("resources/Purchases.csv");
    //protected String path = file.getAbsolutePath();
    private List<String> library = null;

    private List<String> readFile(File file) {
        this.file = file;

        try (Stream<String> lines = Files.lines(file.toPath()  /*Paths.get(path)*/)) {
            this.library = lines.collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return library;
    }

    protected boolean isPresentInLib(String args){
        boolean flag = false;

        for (String book : this.library) {
            if (book.contains(args) || book.toLowerCase().contains(args)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected ArrayList<String[]> booksFoundInLibrary(String args){
        ArrayList<String[]> books = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String book : library){
            String extract = book.replaceAll("[\"]", "");
            if (extract.contains(args) || extract.toLowerCase().contains(args));{
                books.add(extract.split(","));
                books.forEach(sb::append);
            }
        }
        return books;
    }

}







