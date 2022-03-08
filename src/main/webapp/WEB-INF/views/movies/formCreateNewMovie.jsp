<%-- 
    Document   : formCreateNewMovie
    Created on : 29 abr. 2021, 4:03:32
    Author     : kristian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <spring:url value="/resources" var="public"></spring:url>
    <spring:url value="/" var="root"></spring:url>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cinetflix | Nueva Pelicula</title>

    <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../components/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

        <div class="page-header">
          <h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
        </div>
        
        
        <spring:hasBindErrors name="movie">
            <div class="alert alert-danger" role="">
                Accion No Valida.
            </div>
        </spring:hasBindErrors>
        <form:form action="${root}movies/add" method="POST" enctype="multipart/form-data" modelAttribute="movie">
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Título</label>
              <form:input type="text" class="form-control" path="title" id="titulo" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Duracion</label>
              <form:input type="text" class="form-control" path="duration" id="duracion" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="clasificacion" class="control-label">Clasificacion</label>              
              <form:select id="clasificacion" path="classification" class="form-control" items="${classifications}">
              </form:select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Genero</label>              
              <form:select id="genero" path="type" class="form-control" items="${types}">
              </form:select>             
            </div> 
          </div>         
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus" class="control-label">Estatus</label>              
              <form:select id="genero" path="status" class="form-control">
                <form:option value="Active">Activa</form:option>
                <form:option value="Inactive">Inactiva</form:option>               
              </form:select>             
            </div> 
          </div>     
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Estreno</label>             
              <form:input type="text" class="form-control" path="releaseDate" id="fechaEstreno" required="required" autocomplete="off"/>
            </div>  
          </div>

          <div class="col-sm-3">
            <div class="form-group">
                <img class="img-rounded" src="${public}/images/${movie.image}" 
                                 alt="Generic placeholder image" width="150" height="200"> 
  
            </div>  
            <div class="form-group">
              <label for="imagen">Imagen</label>
              <form:hidden path="image"/>
              <input type="file" id="archivoImagen" name="imageFile" />
              <p class="help-block">Imagen de la pelicula</p>
            </div> 
          </div>
        </div>

          
        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
            <form:hidden path="detail.id"></form:hidden>
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <form:input type="text" class="form-control" path="detail.director" id="director" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <form:input type="text" class="form-control" path="detail.actors" id="actores" required="required" />
            </div>  
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <form:input type="text" class="form-control" path="detail.trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>  
          </div> 
        </div> 

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <form:textarea class="form-control" rows="5" path="detail.synopsis" id="sinopsis"></form:textarea>
            </div> 
          </div> 
        </div>
        
        <form:hidden path="id" />
        
        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form:form> 

      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../components/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${public}/bootstrap/js/bootstrap.min.js"></script> 
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
          $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>
