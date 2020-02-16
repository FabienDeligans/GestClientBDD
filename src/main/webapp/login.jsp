<%-- 
    Document   : login
    Created on : 15 févr. 2020, 23:33:30
    Author     : Fabien
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<br />
<br />
<h1 align='center'>Authentification</h1>
<div class="well">
    <form class="form-signin form-horizontal" role="form" action="connecter.user" method="post">
        <div class="form-group">
            <label class="col-md-3 control-label">Login : </label>
            <div class="col-md-3">
                <input type="text" name="login" class="form-control" placeholder="Saisir votre identifiant" required autofocus>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Mot de passe : </label>
            <div class="col-md-3">
                <input type="password" name="pwd"  class="form-control" placeholder="Saisir votre mot de passe" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-log-in"></span> Valider</button>
            </div>
        </div>
    </form>
</div>

