package project.mvc.model;

public class LibraryKindleModel extends LibraryBookModel {
    @Override
    public void setFormat() {
        this.format = "in Kindle format";
    }
}
