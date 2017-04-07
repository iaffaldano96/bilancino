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
        <script src="jquery-ui.min.js" type="text/javascript"></script>
        <link href="jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script>
            $(function () {
                $("#descri").resizable({
                    
                });                
            });                        
        </script>

        <title>Crea Spesa</title>
    </head>
    <body>
        <div id="autenticazione">
            <a href="index.html">Logout</a>            
        </div>
        <h1> Bilancino Personale</h1>
        <br><br><br><br><br><br><br><br><br><br>

        <div id="orologio">            
        </div>
        
        <div id="conteCreaSpesa">

            <a href="home.jsp">
                <div class="link">←</div>
            </a>

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

                <label for="descri">Descrizione</label>&nbsp;&nbsp;    <br>  
                <textarea id="descri" name="descri"></textarea> <br>
                
                <input type="button" id="cmdAnn" value="Annulla">   
                <input type="submit" id="cmdSalva" value="Salva">  
            </form>

            <a href="visualizzaSpese.jsp">
                <div class="link2">Visualizza Spese →</div>
            </a>
        </div>
        <script>        

            $("#importo").css("width","100px");

            $("#cmdAnn").click(function () {
                var s = confirm("Sicuro di voler cancellare?");
                if (s) {
                    $("#importo").val("");
                    $("#descri").val("");
                }
            });

            $(".link2").mouseover(function () {
                $(".link2").css("border-color", "black");
            });

            $(".link2").mouseleave(function () {
                $(".link2").css("border-color", "dimgray");
            });


        </script>   


    </body>
</html>
