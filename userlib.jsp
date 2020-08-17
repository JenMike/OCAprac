<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="./icons/fontawesome-free-5.13.0-web/css/all.css" rel="stylesheet">
    <link href="../src/main/stylesheet.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Weblib | Your Library</title>
</head>
<body>
    <div class="background-image"></div>
    <div class="text-block">
        <form>
            <label for="booksearch" style="color: whitesmoke;"><i class="fas fa-glasses"></i></label>
            <input type="search" id="booksearch" name="booksearch" placeholder="search your library" style="color:whitesmoke; margin-right: 715px;">
            <a href="index.html" style="font-size: 17px;">Logout <i class="fas fa-sign-out-alt"></i></a>
        </form>
            <h1 align="center" style="font-family:fantasy; color: rgb(255, 231, 231)"> Welcome <i class="fas fa-book-reader"></i></h1><br><br>
            <table style="width: 90%;">
            
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><a target="_blank">
                        <img src="./icons/aow.jpg" alt="Art of War">
                      </a>The Art of War - Sun Tzu</td>
                    <td class="tooltip">
                        <button onclick="showAvailable()" id="popupbtn" class="btn"><i class="fas fa-exchange-alt"></i></button>
                        <span class="tooltiptext">return book</span>
                    </td>
                </tr>
                <tr>
                    <td><a target="_blank">
                        <img src="./icons/eo.jpg" alt="Extraordinary Origins">
                      </a>Extraordinary Origins of Everyday Things - Charles Panati</td>
                    <td class="tooltip">
                        <button onclick="showAvailable()" id="popupbtn1" class="btn"><i class="fas fa-exchange-alt"></i></button>
                        <span class="tooltiptext">return book</span>
                    </td>u
                    
                </tr>
                <tr>
                    <td><a target="_blank">
                        <img src="./icons/sholmes.jpg" alt="Sherlock Holmes">
                      </a>Sherlock Holmes - Sir Arthur Conan Doyle</td>
                    <td class="tooltip">
                        <button onclick="showAvailable()" id="popupbtn2" class="btn"><i class="fas fa-exchange-alt"></i></button>
                        <span class="tooltiptext">return book</span>
                    </td>
                </tr>
                <tr>
                    <td><a target="_blank">
                        <img src="./icons/time.jpg" alt="Time Regained">
                      </a>Time Regained - Marcel Proust</td>
                    <td class="tooltip">
                        <button onclick="showAvailable()" id="popupbtn3" class="btn"><i class="fas fa-exchange-alt"></i></button>
                        <span class="tooltiptext">return book</span>    
                    </td>
                </tr>
            </table><br><br>
            <a href="weblib.jsp" style="font-size: 18px; margin-right: 925px;"><i class="far fa-arrow-alt-circle-left"> Weblib Home</i></a>
    <div id="PopUp" class="popup-box">
        <div class="popup">
            <span class="popup-x">&times;</span>
            <p>Book returned! </p>
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