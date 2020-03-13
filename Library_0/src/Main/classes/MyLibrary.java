package Main.classes;
import java.io.File;
import java.lang.Thread;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.String.*;



public class MyLibrary {

    public void returnLibrary(String keyword) {
        List<String> library;
        boolean flag = false;
        String[] array;
        File pathfinder = new File("resources/Purchases.csv");
        String path = pathfinder.getAbsolutePath();

        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            library = lines.collect(Collectors.toList());

            System.out.println("Searching your library... :)");
            System.out.println();
            Thread.sleep(2000);

            for (String book : library) {

                if (book.contains(keyword) || book.toLowerCase().contains(keyword)) {
                    array = book.split(",");

                    for (String elem : array) {
                        System.out.print(elem.replaceAll("[\"]", "") + " ");
                    }
                    System.out.println();
                    flag = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!flag) {
            System.out.println("No books found matching your search");
        }
    }
}