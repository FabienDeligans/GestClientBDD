<%-- 
    Document   : index
    Created on : 15 févr. 2020, 21:45:51
    Author     : Fabien
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/css/gestclients.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <title>Gestion des clients</title>
    </head>
    <body class="body">
        <div class="container">
                <c:import url="/menu.jsp"/>
            <div>
                <c:if test="${vueR != null}">
                    <c:import url="${vueR}"/>
                </c:if>
                <c:if test="${erreurR != null}">
                    <c:import url ="/erreur.jsp"/>
                </c:if>
            </div>
        </div>
    </body>
</html>

