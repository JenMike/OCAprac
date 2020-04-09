package project.mvc.model;

public class LibraryAudibleModel extends LibraryBookModel{
    @Override
    public void setFormat() {
        this.format = "Audible";
    }
}
