<%-- 
    Document   : estoque-inicio
    Created on : 09/06/2016, 11:40:09
    Author     : desenvolvimento
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
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
                    <li class="active"><a href="Estoque">Estoque</a></li>
                    <c:if test="${empty funcionario}">
                       <li><a href="AreasComuns">Áreas Comuns</a></li>
                        <li><a href="Mural">Mural de Comunicação</a></li>
                        <li><a href="ReuniaoInicio">Agendar Reunião</a></li>
                        <li><a href="MoradorInicio">Cadastrar Morador</a></li>
                        <li><a href="VisualizarSolicitacao">Solicitações</a></li>
                        <li><a href="Financeiro">Financeiro</a></li>
                    </c:if>
                    
                        
                        
                    <li><a href="Logoff">Logoff</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <center>
                <c:if test="${empty funcionario}">
                    <a href="CadastrarProduto"><button class="btn btn-lg btn-primary">Cadastrar Produtos</button></a>
                </c:if>
                <a href="ListarEstoque"><button class="btn btn-lg btn-primary">Visualizar Estoque</button></a>
            </center>
        </div>
    </body>
</html>
