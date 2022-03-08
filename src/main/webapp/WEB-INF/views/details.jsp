<%-- 
    Document   : details
    Created on : 28 abr. 2021, 2:01:47
    Author     : kristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
        <title>${movie.title}</title>
        <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">

    </head>

    <body>

        <!-- Fixed navbar -->
        <jsp:include page="components/navbar.jsp"></jsp:include>

        <div class="container theme-showcase" role="main">

            <!-- Marketing messaging -->
            <div class="container marketing">

                    <div class="page-header">
                            <h2>${movie.title}</h2>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <p class="text-center">
                                <img class="img-rounded" 
                                     src="${public}/images/${movie.image}" 
                                     alt="Generic placeholder image" 
                                     width="155" 
                                     height="220"
                                />            
                            </p>
                        </div>
                        <div class="col-sm-9">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">DETALLES</h3>
                                </div>
                                <div class="panel-body">                           
                                    <p>
                                        Título Original : ${movie.title} <br>
                                        Actores : ${movie.detail.actors} <br>
                                        Director: ${movie.detail.director} <br>                  
                                        Clasificación: ${movie.classification} <br>
                                        Duración: ${movie.duration} minutos <br>
                                        Género: ${movie.type} <br>                  
                                        Fecha Estreno: ${movie.releaseDate}                  
                                    </p> 
                                </div>
                            </div>                          
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                                <h3 class="panel-title"><span class="label label-success">20-05-2017</span></h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>                  
                                        <th>Hora</th>
                                        <th>Sala</th>                                  
                                        <th>Precio</th>                                  
                                    </tr>
                                </thead>
                                <tbody>             
                                    <tr>                 
                                        <td>16:00</td>
                                        <td>Sala 1</td>  
                                        <td>$10</td>  
                                    </tr>              
                                    <tr>                 
                                        <td>18:00</td>
                                        <td>Sala 1</td> 
                                        <td>$10</td>  
                                    </tr>              
                                    <tr>                 
                                        <td>20:00</td>
                                        <td>Sala 1</td>                        
                                        <td>$10</td>  
                                    </tr>              
                                    <tr>                
                                        <td>14:00</td>
                                        <td>Sala 1</td>                       
                                        <td>$10</td>  
                                    </tr>              
                                    <tr>               
                                        <td>16:00</td>
                                        <td>Sala 1</td> 
                                        <td>$10</td>  
                                    </tr>                             
                                    <tr>                  
                                        <td>20:00</td>
                                        <td>Sala 1</td> 
                                        <td>$10</td>  
                                    </tr>              
                                    <tr>                 
                                        <td>22:00</td>
                                        <td>Sala 1</td>  
                                        <td>$10</td>  
                                    </tr>              
                                </tbody>           
                            </table>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-sm-7">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Trailer</h3>
                                </div>
                                <div class="panel-body">
                                    <iframe width="100%" 
                                            height="315" 
                                            src="${movie.detail.trailer}" >                          
                                    </iframe>
                                </div>
                            </div>           
                        </div> 
                        <div class="col-sm-5">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">SINOPSIS</h3>
                                </div>
                                <div class="panel-body">
                                    <p>${movie.detail.synopsis}</p>
                                </div>
                            </div>                          
                        </div>
                    </div>

                </div><!-- /.container -->

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