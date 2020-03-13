package Main;

//import org.jetbrains.annotations.NotNull;

import Main.classes.MyLibrary;

public class Main{
    public static void main(String[] args) {
        MyLibrary obj = new MyLibrary();
        if (args.length == 0){
            System.out.println("Please type in a keyword to search!");
        }
        else
            obj.returnLibrary(args[0]);
    }
}