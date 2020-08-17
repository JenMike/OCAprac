//package main.java.dao;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class LibraryLoader implements LibraryHandler {
//    private ArrayList<String> books = new ArrayList<>();
//
//    @Override
//    public ArrayList<String> libReader() {
//        File bookFile = new File("/home/jenmike/IdeaProjects/WeblibApplication_1/src/main/resources/Book.csv");
//
//        try{
//            Stream<String> lines = Files.lines(bookFile.toPath());
//            List<String> library = lines.collect(Collectors.toList());
//
//            for(String line : library){
//                books.add(line);
//            }
//        }
//        catch(IOException ioe){
//            System.out.println("Couldn't read file Book.csv: " + ioe.getMessage());
//        }
//        return books;
//    }
//}
