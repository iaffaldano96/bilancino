<%-- 
    Document   : visualizzaSpese
    Created on : 4-apr-2017, 8.42.35
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
        <title>Lista delle tue Spese</title>
    </head>
    <body>
        <div id="autenticazione">
             <a href="index.html">Logout</a>
        </div>
        <h1> Bilancino Personale</h1>
        <br><br><br><br><br><br><br><br><br><br>

        <div id="conteVisuSpese">
            
            <h2 style="text-align: center"> Ecco i tuoi movimenti</h2>
            
            <table>
                
                <th>ID</th>
                <th>Categoria</th>
                <th>Data</th>
                <th>Importo</th>
                <th>Descrizione</th>
                
                <c:forEach items="${spesaService.findByUser()}" var="spe">
                    <tr>
                        <td><c:out value="${spe.id}"/></td>
                        <td><c:out value="${spe.categoria_categoria}"/></td>
                        <td><c:out value="${spe.data_creato}"/></td>
                        <td><c:out value="${spe.importo}"/></td>
                        <td><c:out value="${spe.descrizione}"/></td>
                    </tr>       
                </c:forEach>

            </table>          
            
        </div>        
        
        
        
    </body>
</html>
