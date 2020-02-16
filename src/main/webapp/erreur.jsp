<%-- 
    Document   : erreur
    Created on : 15 févr. 2020, 21:47:33
    Author     : Fabien
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="form-group" >
    <div class="col-md-5  col-md-offset-3">
        <div class="alert-danger" role="alert">
            <c:if test="${erreurR != null}">                    
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <c:out value="${erreurR}"/>                            
            </c:if>
        </div>
    </div>
</div>