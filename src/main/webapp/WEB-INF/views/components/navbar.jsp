<%-- 
    Document   : navbar
    Created on : 28 abr. 2021, 0:50:50
    Author     : kristian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/" var="root"></spring:url>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" 
                    data-toggle="collapse" data-target="#navbar" 
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <sec:authorize access="isAnonymous()">
                <a class="navbar-brand" href="${root}">
                    <span>Cinetflix</span>
                </a>     
            </sec:authorize>
            <sec:authorize access="hasAnyAuthority('EDITOR','GERENTE')">
                <a class="navbar-brand" href="${root}admin">
                    <span>Cinetflix | Administración </span>
                </a>
            </sec:authorize>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <sec:authorize access="isAnonymous()">
                    <li><a href="${root}about">Acerca</a></li>
                    <li><a href="${root}contact">Contactanos</a></li>            
                    <li><a href="${root}login">Iniciar Sesión</a></li>            
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('EDITOR')">                   
                    <li><a href="${root}movies/list">Peliculas</a></li>
                    <li><a href="#">Horarios</a></li>
                    <li><a href="${root}posts/add">Noticias</a></li>
                    <li><a href="#">Anuncios</a></li>
                    <li><a href="${root}logout">Salir</a></li>            
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('GERENTE')">                   
                    <li><a href="${root}users/add">Usuarios</a></li>
                    <li><a href="${root}movies/list">Peliculas</a></li>
                    <li><a href="#">Horarios</a></li>
                    <li><a href="${root}posts/add">Noticias</a></li>
                    <li><a href="#">Anuncios</a></li>
                    <li><a href="${root}logout">Salir</a></li>            
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>