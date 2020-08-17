<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="main.java.dao.BooksHandler" %>
<%@ page import="main.java.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="./icons/fontawesome-free-5.13.0-web/css/all.css" rel="stylesheet">
    <link href="../src/main/stylesheet.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Weblib | Public Library</title>
</head>
<body>
<div class="background-image"></div>
<div class="text-block">
    <form>
        <label for="booksearch" style="color: whitesmoke;"><i class="fas fa-glasses"></i></label>
        <input type="search" id="booksearch" name="booksearch" placeholder="search for books" style="color:whitesmoke; margin-right: 715px;">
        <a href="index.html" style="font-size: 17px;">Logout <i class="fas fa-sign-out-alt"></i></a>
    </form>
    <h1 align="center" style="font-family:fantasy; color: rgb(255, 231, 231)"> Books to Checkout <i class="fas fa-book-reader"></i></h1><br><br>
        <%
            out.println("tester");
            List<Book> books = new BooksHandler().getListOfBooks();
            out.println("test@");
            out.println("test####");
            for (Book book : books){
                out.println("test");
                out.println(book.getTitle());
                out.println("test3333");
            }
            out.println(books.isEmpty());
            if (books.isEmpty())
                out.println("nothing to print");
            out.println("test4444");
            out.println("hello");
        %>
    <br><br>
    <a href="userlib.jsp" style="font-size: 18px; margin-right: 925px;"> My Library <i class="fab fa-buffer"></i></a>
    <div id="PopUp" class="popup-box">
        <div class="popup">
            <span class="popup-x">&times;</span>
            <p>Book added to your Library! </p>
        </div>
    </div>
    <script>
        var popup = document.getElementById("PopUp");
        var span = document.getElementsByClassName("popup-x")[0];

        showAvailable = function() {
            popup.style.display = "block";
        }
        span.onclick = function() {
            popup.style.display = "none";
        }
    </script>
</div>
</body>
</html>