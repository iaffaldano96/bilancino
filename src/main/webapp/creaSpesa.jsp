<%-- 
    Document   : creaSpesa
    Created on : 4-apr-2017, 8.42.58
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jquery-3.1.1.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crea Spesa</title>
    </head>
    <body>
        <div id="autenticazione">
            <a href="index.html">Logout</a>            
        </div>
        <h1> Bilancino Personale</h1>
        <br><br><br><br><br><br><br><br><br><br>

        <div id="conteCreaSpesa">
            <h2>Inserisci la spesa </h2>

            <form action="crea" method="POST">
                <label for="cate">Categoria</label> &nbsp;

                <select id="cate" name="cate">                     
                    <c:forEach items="${categoriaService.findAll()}" var="cate">                                   
                        <option><c:out value="${cate.categoria}"/></option>                                                    
                    </c:forEach>
                </select>

                <br><br>

                <label for="importo">Importo</label>&nbsp;&nbsp;          
                <input type="text" id="importo" name="importo"><br><br>

                <label for="descri">Descrizione</label>&nbsp;&nbsp;
                <textarea id="descri" name="descri"></textarea><br><br>

                <input type="button" id="cmdAnn" value="Annulla">   
                <input type="submit" id="cmdSalva" value="Salva">  
            </form>
        </div>
        <script>

            $("#cmdAnn").click(function () {
                var s = confirm("Sicuro di voler cancellare?");
                if (s) {
                    //$("#cate option").val("0");
                    $("#importo").val("");
                    $("#descri").val("");
                }
            });

        </script>   


    </body>
</html>
