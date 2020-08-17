package main.java.dao;

import main.java.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BooksHandler implements BookDAO{
    private List<Book> bookList = new ArrayList<>();

    public BooksHandler(){}

    @Override
    public void addBook(Book book) {
        Connection conn = null;
        String sql = String.format("insert into %s values(?,?,?)", BOOK_TABLE);
        PreparedStatement ps;
        try {
            conn = DatabaseConnection.getConnection();
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(Objects.nonNull(conn)) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Book> getListOfBooks(){
    //    List<Book> bookList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(String.format("select * from %s", BOOK_TABLE));
            while (rs.next()) {
                String Title = rs.getString(COLUMN_TITLE);
                String Author = rs.getString(COLUMN_AUTHOR);
                bookList.add(new Book(Title, Author));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//                finally {
//            if(Objects.nonNull(conn)) {
//                try {
//                    conn.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//        }
        return bookList;
    }

//    public static void main (String[] args){
//        System.out.println("tester");
//        List<Book> books = new BooksHandler().getListOfBooks();
//        System.out.println("hello");
//        for(Book book : books){
//            System.out.println(book.getTitle() + book.getAuthor());
//        }
//        System.out.println("test TWO");
//    }

    @Override
    public Book getBookById(int id){
        Connection conn = DatabaseConnection.getConnection();
        String sql = String.format("select * from %s where %s='%d'", BOOK_TABLE, COLUMN_ID, id);
        Book book = new Book();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString(COLUMN_TITLE);
                String author = rs.getString(COLUMN_AUTHOR);
                book = new Book(title, author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(Objects.nonNull(conn)) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return book;
    }
}
