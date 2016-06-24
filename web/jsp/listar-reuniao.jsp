<%-- 
    Document   : listar-reuniao
    Created on : 23/06/2016, 03:07:52
    Author     : prisl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Reunioes</title>
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
                        <li><a href="ReuniaoInicio">Agendar Reuniao</a></li>
                        <li><a href="Logoff">Logoff</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <h2>Reuniões Agendadas</h2>
            <table class="table">
                <tr class="text-primary">
                    <td>Assunto</td>
                    <td>Pauta</td>
                    <td>Criador da Reuniao</td>
                    <td>Data da Reuniao</td>
                    <td>Hora Reuniao</td>
                </tr>
                <c:forEach items="${reunioes}" var="r">
                    <tr>
                        <td>${r.assunto}</td>
                        <td>${r.pauta}</td>
                        <td>${r.morador.login}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${r.data}" /></td>
                        <td>00:00</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>