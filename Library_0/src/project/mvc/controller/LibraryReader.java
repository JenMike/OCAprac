package project.mvc.controller;

import project.mvc.model.*;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryReader{

    private List<LibraryBookModel> bookModels = new ArrayList<>();

    public LibraryReader(){}

    private void readFileIntoList() {
        File file = new File("resources/Purchases.csv");

        //List<LibraryBookModel> books = new ArrayList<>();
        try (Stream<String> lines = Files.lines(file.toPath()).filter(c -> c.contains(","))){
            List<String> library = lines.collect(Collectors.toList());
            for (String line : library) {
                String[] lineParts = line.split(",");
                String format = "";
                if (lineParts.length == 4) {
                    format = lineParts[3];
                }
                LibraryBookModel book;
                switch (format){
                    case "Hardcover":
                        book = new LibraryHardcoverModel();
                        break;
                    case "Audible":
                        book = new LibraryAudibleModel();
                        break;
                    case "Kindle":
                        book = new LibraryKindleModel();
                        break;
                    case "Box Set":
                        book = new LibraryBoxSetModel();
                        break;
                    case "DVD":
                        book = new LibraryDVDModel();
                        break;
                    default:
                        book = new LibraryPaperbackModel();
                }
                book.setTitle(lineParts[0]);
                book.setAuthor(lineParts[1]);
                book.setSku(lineParts[2]);
                book.setFormat();
                bookModels.add(book);

            }

        } catch (Exception e) {
            System.out.println("An error occurred! " + e.getMessage());
        }
    }

    //keyword only searches on title
    public ArrayList<String> searchAndReturn(String keyword){
        if (bookModels.isEmpty()){
            readFileIntoList();
        }
        ArrayList<String> searchResults = new ArrayList<>();

        for (LibraryBookModel book : bookModels){
            String testTitle = book.getTitle();

            if (testTitle.toLowerCase().contains(keyword.toLowerCase())){
                searchResults.add(book.toString());
            }
        }
        return searchResults;
    }
}








