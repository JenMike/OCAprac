package main.java.dao;

import main.java.model.Book;

import java.util.List;

public interface BookDAO {
    static String BOOK_TABLE = "Books";
    static String COLUMN_ID = "id";
    static String COLUMN_TITLE = "Title";
    static String COLUMN_AUTHOR = "Author";

    void addBook(Book book);

    List<Book> getListOfBooks();

    Book getBookById(int id);

  //  List<Book> searchList(String wordToSearch);
}
