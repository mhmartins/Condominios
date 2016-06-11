<%-- 
    Document   : listar-estoque
    Created on : 09/06/2016, 20:37:40
    Author     : Tuka
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
                    <li class="active"><a href="Estoque">Controle de Estoque</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        
        <div class="container">
            <h2>Produtos em Estoque</h2>
            <table class="table">
                <tr class="text-primary">
                    <td style="width: 20%">Nome</td>
                    <td>Descrição</td>
                    <td style="width:10%; text-align: center">Quantidade</td>
                    <td></td>
                </tr>
                 
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td align="center">${produto.quantidade}</td>
                    <td><a href="EditarProduto?id=${produto.id}"><img src="img/edit.png" width="20" height="20"/></a></td>
                </tr>
                
            </c:forEach>
                
            </table>
        </div>
        
    </body>
</html>
