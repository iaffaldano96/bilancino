<%-- 
    Document   : login
    Created on : 3-apr-2017, 9.35.18
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery-3.1.1.js" type="text/javascript"></script>
        <title>Login</title>
    </head>
    <body>
        <div id="autenticazione">
            <a href="login.jsp">Login</a>
            <a href="registrazione.jsp">Registrazione</a>
        </div>
        <h1 style="text-align: center">Bilancino Personale</h1>
        <br><br><br><br><br><br><br><br><br><br>

        <h2>Inserisci i dati </h2>

        <form action="login" method="POST">
            <label for="usr">Username:</label> &nbsp;
            <input type="text"  name="usr" id="usr"><br><br>

            <label for="psw">Password:</label>&nbsp;&nbsp;
            <input type="password" name="psw" id="psw"><br><br>

            <input type="button" id="cmdAnn" value="Annulla">   
            <input type="submit" id="cmdSalva" value="Salva">  
        </form>
        <script>

            $("#cmdAnn").click(function() {
                var s=confirm("Sicuro di voler cancellare?");
                if(s){
                    $("#usr").val("");
                    $("#psw").val("");
                }                    
            });

        </script>   
    </body>
</html>
