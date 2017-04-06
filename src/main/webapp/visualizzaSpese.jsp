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

            <a href="home.jsp">
                <div class="link">←</div>
            </a>

            <h2 style="text-align: center"> Ecco i tuoi movimenti</h2>
            <br>
            <div id="scelta">
                <label>Scegli di visualizzare per categoria</label>

                <form action="visualizzaSpese.jsp" method="GET">

                    <select id="categ" name="categ">   
                        <option >Tutti</option>

                        <c:forEach items="${categoriaService.findAll()}" var="cate">
                            <c:if test="${param.categ eq cate.categoria}">
                                <option selected><c:out value="${cate.categoria}"/> </option>     
                            </c:if>

                            <c:if test="${param.categ != cate.categoria}">
                                <option><c:out value="${cate.categoria}"/> </option>     
                            </c:if>    
                        </c:forEach>
                    </select>
                    <input type="submit" value="VISUALIZZA">
                </form>

            </div>

            <br><br>

            <c:if test="${param.categ eq "Tutti"}">
                <table>                
                    <th>Categoria</th>
                    <th>Data</th>
                    <th>Importo</th>
                    <th>Descrizione</th>                
                        <c:forEach items="${spesaService.findByUser()}" var="spe">
                        <tr>  <!-- spe. e poi devi utilizzare le variabili con il nome che hanno sulle Entity, non sul db -->
                            <td><c:out value="${spe.categoria.categoria}"/></td>
                            <td><c:out value="${spe.dataSalvato}"/></td>
                            <td><c:out value="${spe.importo}"/></td>
                            <td><c:out value="${spe.descrizione}"/></td>
                        </tr>       
                    </c:forEach>
                </table>  
            </c:if>



        </div>        

        <script>

            $(".link").mouseover(function () {
                $(".link").css("border-color", "black");
            });

            $(".link").mouseleave(function () {
                $(".link").css("border-color", "dimgray");
            });

        </script>                        

    </body>
</html>
