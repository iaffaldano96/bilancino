<%-- 
    Document   : visualizzaCategorie
    Created on : 5-apr-2017, 9.12.18
    Author     : tss
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script src="jquery-3.1.1.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizzazione Per Categorie</title>
    </head>
    <body>
        <div id="autenticazione">
            <a href="index.html">Logout</a>
        </div>
        <h1> Bilancino Personale</h1>
        <br><br><br><br><br><br><br><br><br><br>     

        <div id="conteVisuSpese">

            <h2 style="text-align: center"> Ecco i tuoi movimenti</h2>
            <br>

            <div id="scelta">
                <label>Scegli come visualizzare i tuoi movimenti</label>
                <form action="visualizza" method="POST">
                    <select id="categ" name="categ">  
                        <option>Tutti</option>
                        <c:forEach items="${categoriaService.findAll()}" var="cate">
                            <option><c:out value="${cate.categoria}"/> </option>                                            
                        </c:forEach>
                    </select>
                    <input type="submit" value="VISUALIZZA">
                </form>

            </div>

            <br><br>


            <table>                
                <th>Categoria</th>
                <th>Data</th>
                <th>Importo</th>
                <th>Descrizione</th>                
                    <c:forEach items="${spesaService.findByCategoria()}" var="sp">
                    <tr> 
                        <td><c:out value="${sp.categoria.categoria}"/></td>
                        <td><c:out value="${sp.dataSalvato}"/></td>
                        <td><c:out value="${sp.importo}"/></td>
                        <td><c:out value="${sp.descrizione}"/></td>
                    </tr>       
                </c:forEach>
            </table>             
        </div>  
    </body>
</html>
