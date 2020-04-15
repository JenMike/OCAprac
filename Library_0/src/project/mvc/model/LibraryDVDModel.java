package project.mvc.model;

public class LibraryDVDModel extends LibraryBookModel {
    @Override
    public void setFormat() {
        this.format = "in DVD format";
    }
}
