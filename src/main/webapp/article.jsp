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
        <%
            List<Article> liste = (List<Article>) request.getSession().getAttribute("listeArticle");
            liste.add(new Article("1", "un"));
            String test = (String) request.getSession().getAttribute("test");

        %>
        <h1>Hello World!</h1>
        <c:out value="size of list : ${liste.size()}" />
        <c:forEach var="article" items="${ liste }">
            <tr>
                <td>issou</td>
                <td><c:out value="${article.getId()}"/></td>
            </tr>
        </c:forEach>
    </body>
</html>
