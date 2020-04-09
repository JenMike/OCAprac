package project.mvc.model;

public class LibraryHardcoverModel extends LibraryBookModel{
    @Override
    public void setFormat() {
        this.format = "Hardcover";
    }
}
