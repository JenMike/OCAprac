package project.mvc.functionality;

import project.mvc.MyLibraryModel;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryReader{
    private MyLibraryModel model;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> author = new ArrayList<>();
    private ArrayList<String> sku = new ArrayList<>();
    private ArrayList<String> format = new ArrayList<>();

    public LibraryReader(){}

    private String[][] readFileIntoArrays() {
        File file = new File("resources/Purchases.csv");
        List<String> library = null;

        String[][] books = new String[0][];
        try (Stream<String> lines = Files.lines(file.toPath())) {
            library = lines.collect(Collectors.toList());
            books = new String[library.size()][];
            int count = 0;
            for (String item : library) {
                books[count] = item.split(",");
                count++;
            }
        } catch (Exception e) {
            System.out.println("An error occurred! " + e.getMessage());
        }
        return books;
    }

    public ArrayList<String> searchAndReturn(String keyword){
        String[][] yourLibrary = readFileIntoArrays();
        ArrayList<String> searchResults = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        int i;
        int row = 0;
        int col = 0;

        for (row = 0; row < yourLibrary.length; row++){

            for (col = 0; col < yourLibrary[row].length; col++){

                if (yourLibrary[row][col].contains(keyword)){

                    i = 0;

                    while (i < 4) {
                        if (yourLibrary[row][i].isEmpty()){
                            i++;
                        }
                        switch (i){
                            case 0:
                            case 2:
                                sb.append(yourLibrary[row][i]);
                                break;
                            case 1:
                                sb.append(", by ").append(yourLibrary[row][i]);
                                break;
                            case 3:
                                sb.append(" in ").append(yourLibrary[row][3]).append(" format");
                                break;
                        }
                        i++;
                    }
                    sb.append("\n");
                }
            }
        }
        searchResults.add(sb.toString().replaceAll("[\"]", ""));
        return searchResults;
    }
}








