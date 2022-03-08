<%-- 
    Document   : listMovies
    Created on : 29 abr. 2021, 15:23:14
    Author     : kristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
            <title> Cinetflix | Listado de Peliculas</title>

            <link href="${public}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${public}/bootstrap/css/theme.css" rel="stylesheet">

    </head>

    <body>
        
        <!-- NAVBAR-->
        <jsp:include page="../components/navbar.jsp"></jsp:include>

            <div class="container theme-showcase" role="main">

                <h3>Listado de Peliculas</h3>
            <c:if test="${message != null}">
                <p id="alerts" class="alert alert-info">${message}</p>          
            </c:if>
            <a href="${root}movies/add" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>

            <div class="table-responsive">
                <table class="table table-hover table-striped table-bordered">
                    <tr>
                        <th>Titulo</th>
                        <th>Genero</th>
                        <th>Clasificacion</th>
                        <th>Duracion</th>
                        <th>Fecha Estreno</th>
                        <th>Estatus</th>
                        <th>Opciones</th>
                    </tr>
                    <c:forEach items="${movies}" var="movie">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.type}</td>
                            <td>${movie.classification}</td>
                            <td>${movie.duration} min</td>
                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${movie.releaseDate}"></fmt:formatDate></td>
                            <c:set var="isActive" value="Active"></c:set>
                            <c:choose>

                                <c:when test="${ movie.status.equals(isActive) }">
                                    <td><span class="label label-success">Activa</span></td>
                                </c:when>
                                <c:otherwise>
                                    <td><span class="label label-danger">Inactiva</span></td>
                                </c:otherwise>
                            </c:choose>
                            <td>
                                <a href="${root}movies/edit/${movie.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                                <a href="${root}movies/delete/${movie.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" onclick="confirmDelete()"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr> 
                    </c:forEach>
                </table>
            </div>

            <hr class="featurette-divider">

            <!-- FOOTER -->
            <jsp:include page="../components/footer.jsp"></jsp:include>
            
            
            </div> 
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
            <script src="${public}/bootstrap/js/bootstrap.min.js"></script>
            <script>
                const $alerts = document.querySelector("#alerts");
                if ($alerts) {
                    setTimeout(function () {
                        $alerts.remove();
                    }, 3000);
                }
                function confirmDelete(){
                    window.confirm("¿Estas seguro que deseas eliminar este registro?")
                }
            </script>  
    </body>
</html>
