package project.mvc.model;

public class LibraryBoxSetModel extends LibraryBookModel {

    @Override
    public void setFormat() {
        this.format = "Box Set";
    }
}
