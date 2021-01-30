<%-- 
    Document   : article
    Created on : 20 janv. 2021, 18:36:48
    Author     : ViJAN
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Article" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mon Panier</h1>
      
        <c:forEach var="article" items="${ listeArticle }">
            <tr>

                <br></br>
                <td><c:out value="${article.getId()} : ${article.getName()} => ${article.getDescription()}"/></td>
            </tr>
        </c:forEach>
        
        <form action="" method="post" >  
            <c:forEach var="article" items="${ listeArticle }">
                <tr>
                    <br></br>
                    <td><input type='checkbox' id="" name="selectedValue" value="${article.getName()} => ${article.getDescription()}"/></td>
                </tr>
            </c:forEach>
             <br/>
            <input type="submit" value="Ajouter">
        </form>

    </body>
</html>