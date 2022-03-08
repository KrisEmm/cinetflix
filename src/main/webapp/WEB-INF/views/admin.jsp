<%-- 
    Document   : admin
    Created on : 14 may. 2021, 19:14:51
    Author     : kristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
        <title>Cinetflix | Administración </title>    
  </head>

  <body>

    <jsp:include page="components/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <div class="jumbotron">        
        <h3>Administración del Sistema</h3>
        <p>Bienvenido(a) 
            <strong class="text-capitalize">
                <sec:authentication property="principal.username"/>
            </strong> 
        </p>
      </div>

      
      <jsp:include page="components/footer.jsp"></jsp:include>

    </div> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${public}/bootstrap/js/bootstrap.min.js"></script> 
    <script>
      function goBack() {
         window.history.back();
      }
    </script>
  </body>
</html>
