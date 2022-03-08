<%-- 
    Document   : formCreateNews
    Created on : 28 abr. 2021, 19:24:54
    Author     : kristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <spring:url value="/resources" var="public" ></spring:url> 
    <spring:url value="/" var="root"></spring:url>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cinetflix | Nueva Noticia</title>    
    <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
    <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../components/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3 class="blog-title"><span class="label label-success">Datos de la Noticia</span></h3>

      <form action="${root}posts/add" method="POST">
        <div class="row">         
          <div class="col-sm-6">
            <div class="form-group">
              <label for="titulo">Titulo</label>             
              <input type="text" class="form-control" name="title" id="titulo" required="required"/>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus">Estatus</label>             
              <select id="estatus" name="status" class="form-control">
                <option value="Activa">Activa</option>
                <option value="Inactiva">Inactiva</option>                
              </select>  
            </div>
          </div>
        </div>
        <div class="row"> 
          <div class="col-sm-12">
            <div class="form-group">
              <label for="detalle">Detalles</label>             
              <textarea class="form-control" name="details" id="detalle" rows="10"></textarea>
            </div>  
          </div>
        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form> 

      <hr class="featurette-divider">
      
      <!-- FOOTER -->
      <jsp:include page="../components/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${public}/bootstrap/js/bootstrap.min.js"></script> 
    <script src="${public}/tinymce/tinymce.min.js"></script>
    <script>
      tinymce.init({
          selector: '#detalle',
          plugins: "textcolor, table lists code",
          toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
      });
    </script>
  </body>
</html>