<%-- 
    Document   : formContact
    Created on : 1 may. 2021, 0:04:04
    Author     : kristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <spring:url value="/resources" var="public"></spring:url>
      <spring:url value="/" var="root"></spring:url>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">    
      <meta name="author" content="">
      <title>Cinetflix | Contacto</title>
      <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
      <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">

   </head>

   <body>

       <jsp:include page="components/navbar.jsp"></jsp:include>

      <div class="container theme-showcase" role="main">

         <h3 class="blog-title text-center"><span class="label label-success">Contacto</span></h3><br>  
         
         <form:form action="${root}contact" method="POST" class="form-horizontal" modelAttribute="contact">
            <div class="form-group">
               <label for="nombre" class="col-sm-2 control-label">Nombre</label>
               <div class="col-sm-10">
                  <form:input type="text" class="form-control" id="nombre" path="name" placeholder="Nombre" required="required"/>
               </div>
            </div>
            <div class="form-group">
               <label for="email" class="col-sm-2 control-label">Email</label>
               <div class="col-sm-10">
                  <form:input type="email" class="form-control" path="email" id="email" placeholder="Email" required="required"/>
               </div>
            </div>

            <div class="form-group">
               <label for="genero" class="col-sm-2 control-label">Géneros Favoritos</label>
               <div class="col-sm-10">
                   <form:select id="genero" path="types" multiple="multiple" class="form-control" items="${types}" />
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Tu experiencia en el sitio</label>
               <div class="col-sm-10">
                   <c:forEach items="${ratings}" var="rating">
                    <label><form:radiobutton path="rating" value="${rating.key}"/>${rating.value}</label>
                   </c:forEach>
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Te gustaría recibir notificaciones de:</label>
               <div class="col-sm-10">
                   <form:checkboxes items="${notifications}" path="notifications"/>
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Comentarios:</label>
               <div class="col-sm-10">
                  <form:textarea class="form-control" path="comments" id="comentarios" rows="5"/>
               </div>
            </div>
                  <form:hidden path="id" />
            <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-success">Enviar</button>
               </div>
            </div>

         </form:form>

         <hr class="featurette-divider">

         <!-- FOOTER -->
      <jsp:include page="components/footer.jsp"></jsp:include>

      </div> <!-- /container -->

      <!-- Bootstrap core JavaScript
      ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
      <script src="${public}/bootstrap/js/bootstrap.min.js"></script> 		
   </body>
</html>
