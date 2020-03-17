package project.mvc;
import project.mvc.LibraryView;
import project.mvc.MyLibraryModel;

public class LibraryController{
    private LibraryView view;
    private MyLibraryModel model;

    public LibraryController(MyLibraryModel model, LibraryView view){
        this.model = model;
        this.view = view;
    }

    public void setLibraryModelOption(String option) {
        model.setOption(option);
    }

    public String getLibraryModelOption(){
        return model.getOption();
    }

    public void setLibraryModelKey(String keyword) {
        model.setKeyword(keyword);
    }

    public String getLibraryModelKey(){
        return model.getKeyword();
    }

    public void renderView(){
        view.printLibrary(model.getOption(), model.getKeyword());
    }
}