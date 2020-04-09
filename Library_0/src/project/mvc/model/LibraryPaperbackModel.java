package project.mvc.model;

public class LibraryPaperbackModel extends LibraryBookModel{
    @Override
    public void setFormat() {
        this.format = "Paperback";
    }
}
