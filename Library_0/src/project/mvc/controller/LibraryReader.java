package project.mvc.controller;

import project.mvc.model.LibraryBookModel;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryReader{

    public LibraryReader(){}

    private List<LibraryBookModel> readFileIntoList() {
        File file = new File("resources/Purchases.csv");

        List<LibraryBookModel> books = new ArrayList<>();
        try (Stream<String> lines = Files.lines(file.toPath()).filter(c -> c.contains(","))){
            List<String> library = lines.collect(Collectors.toList());
            for (String line : library) {
                LibraryBookModel book = new LibraryBookModel();
                String[] lineParts = line.split(",");
                book.setTitle(lineParts[0]);
                book.setAuthor(lineParts[1]);
                book.setSku(lineParts[2]);
                if (lineParts.length == 4) {
                    book.setFormat(lineParts[3]);
                }
              //  System.out.println(book.toString());
                books.add(book);
            }

        } catch (Exception e) {
            System.out.println("An error occurred! " + e.getMessage());
        }
        return books;
    }

    //keyword only searches on title
    public ArrayList<String> searchAndReturn(String keyword){
        List<LibraryBookModel> yourLibrary = readFileIntoList();
        ArrayList<String> searchResults = new ArrayList<>();
        //StringBuilder sb = new StringBuilder("");
        //int i;
        //int row = 0;
        //int col = 0;

        for (LibraryBookModel book : yourLibrary){
            String testTitle = book.getTitle();
            if(testTitle.toLowerCase().contains(keyword.toLowerCase())){
                searchResults.add(book.toString());
            }
            //
//            for (col = 0; col < yourLibrary[row].length; col++){
//
//                if (yourLibrary[row][col].contains(keyword)){
//
//                    i = 0;
//
//                    while (i < 4) {
//                        if (yourLibrary[row][i].isEmpty()){
//                            i++;
//                        }
//                        switch (i){
//                            case 0:
//                            case 2:
//                                sb.append(yourLibrary[row][i]);
//                                break;
//                            case 1:
//                                sb.append(", by ").append(yourLibrary[row][i]);
//                                break;
//                            case 3:
//                                sb.append(" in ").append(yourLibrary[row][3]).append(" format");
//                                break;
//                        }
//                        i++;
//                    }
//                    sb.append("\n");
//                }
//            }
        }
        //searchResults.add(sb.toString().replaceAll("[\"]", ""));
        return searchResults;
    }
}








