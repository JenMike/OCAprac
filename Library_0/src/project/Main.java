package project;

import project.mvc.LibraryController;
import project.mvc.LibraryView;
import project.mvc.MyLibraryModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main implements Runnable{

    static BufferedReader in ;  static int quit=0;

    public void run(){
        String msg = null;
        while(true){
            try{
                msg=in.readLine();
                //System.out.println("Type a search word: ");
                String keyword = msg;
                //System.out.println("Option: ");
                String option = msg;
                MyLibraryModel model = returnBooksInLibrary(option, keyword); // -t  -a -s -f
                LibraryView view = new LibraryView();
                LibraryController controller = new LibraryController(model, view);

                controller.renderView();
            }catch(Exception e){}

            if(msg.equals("Q")) {quit=1;break;}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        in=new BufferedReader(new InputStreamReader(System.in));

        Thread t1=new Thread(new Main());
        t1.start();

        System.out.println("Type a keyword to search or hold shift and press Q to terminate");

        while(true){
            t1.sleep(10);
            if(quit==1) break;
            new Main().run();

        }
    }
    private static MyLibraryModel returnBooksInLibrary(String option, String keyword){
        MyLibraryModel model = new MyLibraryModel();
        model.setOption(option);
        model.setKeyword(keyword);
        return model;
    }
}