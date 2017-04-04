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
            <br>

            <label>Scegli come vuoi visualizzare i tuoi movimenti</label>

            <select id="visualizzazione">
                <option value="all">Tutti</option>
                <option value="cate">Per categoria</option>
            </select>

            <select id="categ">
                <option value="">Scegli la categoria</option>
                <c:forEach items="${categoriaService.findAll()}" var="cate">
                    < option ><c:out value="${cate.categoria}"/> < /option>                                            
                </c:forEach>
            </select>

            <!--<c:if></c:if>-->
            
            
            <table>                
                <th>ID</th>
                <th>Categoria</th>
                <th>Data</th>
                <th>Importo</th>
                <th>Descrizione</th>                
                    <c:forEach items="${spesaService.findByUser()}" var="spe">
                    <tr>  <!-- spe. e poi devi utilizzare le variabili con il nome che hanno sulle Entity, non sul db -->
                        <td><c:out value="${spe.id}"/></td>
                        <td><c:out value="${spe.categoria.categoria}"/></td>
                        <td><c:out value="${spe.dataSalvato}"/></td>
                        <td><c:out value="${spe.importo}"/></td>
                        <td><c:out value="${spe.descrizione}"/></td>
                    </tr>       
                </c:forEach>
            </table>          

        </div>        

        <script>

            $("#visualizzazione").change(function () {

                $("#categ option").remove();



            });

        </script>


    </body>
</html>
