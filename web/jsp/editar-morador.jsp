<%-- 
    Document   : editar-morador
    Created on : 24/06/2016, 00:19:43
    Author     : prisl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <!-- ALTERAR ESSE CARA -->
        <div class="container" style="width:40%">
            <form action="EditarMorador" method="POST">                
                <h4>Login:</h4>
                <input type="text" name="login" id="nome" class="form-control" value="${morador.login}"/>
                <h4>Senha:</h4>
                <input type="password" name="senha" id="senha" class="form-control" value="${morador.senha}"/>
                <h4>Numero Apartamento:</h4>
                <input type="number" name="numApt" id="numApt" class="form-control width40" value="${morador.numApt}"/>
                <input type="hidden" name="id" id="id" value="${morador.id}"/>
                <br /><input type="submit" value="Atualizar" class="btn btn-lg btn-primary btn-block width40 center-block"/>
                
            </form>
            
        </div>
    </body>
</html>