<%-- 
    Document   : form
    Created on : 14 may. 2021, 23:35:49
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
        <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
        <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">
        <title>Cinetflix | Nuevo Usuario</title>
    </head>

    <body>

         <jsp:include page="../components/navbar.jsp"></jsp:include>

        <div class="container theme-showcase" role="main">

            <h3 class="blog-title"><span class="label label-success">Datos del Usuario</span></h3>  

            <form:form action="${root}users/add" method="POST" modelAttribute="user">
                <div class="row">         
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="perfil" class="control-label">Perfil</label>              
                            <select id="perfil" name="profile" class="form-control">
                                <option value="EDITOR">EDITOR</option>
                                <option value="GERENTE">GERENTE</option>								
                            </select>             
                        </div> 
                    </div>
                </div>	
                <div class="row"> 	
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="username">Usuario</label>             
                            <form:input type="text" class="form-control" path="username" id="username" required="required"/>
                        </div>  
                    </div>

                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="password">Password</label>             
                            <form:input type="password" class="form-control" path="password" id="password" required="required"/>
                        </div>  
                    </div>

                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
                        </div>  
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="phone">Teléfono</label>
                            <form:input type="text" class="form-control" path="phone" id="phone" required="required"/>
                        </div>  
                    </div>

                </div>

                <button type="submit" class="btn btn-danger" >Guardar</button>
            </form:form> 

            <hr class="featurette-divider">

            <jsp:include page="../components/footer.jsp"></jsp:include>

        </div> 
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <script src="${public}/bootstrap/js/bootstrap.min.js"></script>    
    </body>
</html>
