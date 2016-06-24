<%-- 
    Document   : listar-agendamento
    Created on : 22/06/2016, 23:25:14
    Author     : Tobias
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
                    <li class="active"><a href="AreasComuns">Áreas Comuns</a></li>
                    <li><a href="Mural">Mural de Comunicação</a></li>
                    <li><a href="MoradorInicio">Cadastrar Morador</a></li>
                    <li><a href="Logoff">Logoff</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        
        
        <div class="container">
            <table class="table">
                <tr class="text-primary">
                <td>Area</td>
                <td>Agendado Por</td>
                <td>Horário</td>
            </tr>
            <c:forEach items="${agendamentos}" var="agendamento">
                <tr>
                    <td>${agendamento.area.nome}</td>
                    <td>${agendamento.morador.login}</td>
                    <td>00:00</td>
                </tr>
                
            </c:forEach>
        </table>
        </div>
        
        
        
    </body>
</html>
