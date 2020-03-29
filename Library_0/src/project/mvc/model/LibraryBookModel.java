package project.mvc.model;

public class LibraryBookModel{
    private String title;
    private String author;
    private String sku;
    private String format;

    public LibraryBookModel(){}
    public LibraryBookModel(String title, String author, String sku, String format) {
        this.title = title;
        this.author = author;
        this.sku = sku;
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return title + '\'' + author + '\'' + sku + '\'' + format + '\'' +
                '\n';
    }
}