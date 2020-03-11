import java.lang.Thread;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.String.*;

	

public class MyLibrary {

    public void returnLibrary(String keyword){
        List<String> library;
        boolean flag = false;
        String[] array;

        try(Stream<String> lines = Files.lines(Paths.get("./Purchases.csv"))){
            library = lines.collect(Collectors.toList());

            System.out.println("Searching your library... :)");
            System.out.println();
            Thread.sleep(2000);

            for(String book : library){

                if (book.contains(keyword) || book.toLowerCase().contains(keyword)){
                    array = book.split(",");

                    for (String elem : array) {
                        System.out.print(elem.replaceAll("[\"]", "") + " ");
                    }
                    System.out.println();
                    flag = true;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        if(!flag) {
            System.out.println("No books found matching your search");
        }
    }
    public static void main(String[] args) {
        MyLibrary obj = new MyLibrary();
        if (args.length == 0){
            System.out.println("Please type in a keyword to search!");
        }
        else
	        obj.returnLibrary(args[0]);
    }
}

