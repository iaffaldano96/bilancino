<%-- 
    Document   : index
    Created on : 30-mar-2017, 10.25.37
    Author     : tss
--%>

<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div id="autenticazione">
             <a href="index.html">Logout</a>
        </div>
        <h1>Bilancino Personale</h1>
        <br><br><br><br><br><br><br><br><br><br>
        <div id="pulsanti">
            <form action="visualizzaSpese.jsp">
                <input type="submit"  id="visualizza" value="Visualizza le Spese">
            </form>
            <br><br>
            <form action="creaSpesa.jsp">
                <input type="submit"  id="inserisci" value="Inserisci una Spesa">
            </form>
        </div>

    </body>
</html>
