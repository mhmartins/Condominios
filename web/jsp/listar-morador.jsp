<%-- 
    Document   : listar-morador
    Created on : 23/06/2016, 23:16:29
    Author     : prisl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Moradores</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Abrir menu</span>
                  </button>
                  <a class="navbar-brand" href="#">Condominios</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                  <ul class="nav navbar-nav">
                    <li><a href="Principal">Inicio</a></li>
                    <li><a href="Estoque">Controle de Estoque</a></li>
                    <li><a href="AreasComuns">Áreas Comuns</a></li>
                    <li><a href="Mural">Mural de Comunicação</a></li>
                    <li class="active"><a href="MoradorInicio">Cadastrar Morador</a></li>
                    <li><a href="Logoff">Logoff</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <h2>Moradores Cadastrados</h2>
            <table class="table">
                <tr class="text-primary">
                    <td>Editar</td>
                    <td>Nome</td>
                    <td>Apartamento</td>
                </tr>
                <c:forEach items="${moradores}" var="m">
                    <tr>
                        <td><a href="EditarMorador?id=${m.id}"><img src="img/edit.png" width="20" height="20"/></a></td>
                        <td>${m.login}</td>
                        <td>${m.numApt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>