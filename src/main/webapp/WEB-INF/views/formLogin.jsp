<%-- 
    Document   : formLogin
    Created on : 14 may. 2021, 17:11:33
    Author     : kristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources" var="public"></spring:url>
        <spring:url value="/" var="root"></spring:url>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
        <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">
        <link href="${public}/bootstrap/css/signin.css" rel="stylesheet">
        <title>Cinetflix | Iniciar Sesión</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>
        <div class="container theme-showcase" role="main">
            <hr class="featurette-divider">
            <img src="${public}/images/login.png" width="136" height="136" class="center">
            <form class="form-signin" action="${root}login" method="POST">
                <h3 class="form-signin-heading text-center">Administración</h3>        
                <h3 class="form-signin-heading text-center">Iniciar Sesión</h3>  
                <c:if test="${param.error != null}">
                    <h4 class="form-signin-heading text-center text-danger">Acceso denegado</h4>        
                    <p class="text-center text-danger">Usuario o Contraseña no son validos</p>        
                </c:if>
                <label for="username" class="sr-only">Usuario</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
                <label for="password" class="sr-only">Contraseña</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            </form>

        </div> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${public}/bootstrap/js/bootstrap.min.js" ></script>
    </body>
</html>
