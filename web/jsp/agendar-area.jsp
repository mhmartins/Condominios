<%-- 
    Document   : agendar-area
    Created on : 21/06/2016, 13:03:48
    Author     : desenvolvimento
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
                    <li><a href="ReuniaoInicio">Agendar Reunião</a></li>
                    <li><a href="MoradorInicio">Cadastrar Morador</a></li>
                    <li><a href="VisualizarSolicitacao">Solicitações</a></li>
                    <li><a href="Logoff">Logoff</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        
       <div class="container" style="width:40%">
            <form action="AgendarArea" method="POST">                
                <h4>Área: </h4>
                <select class="form-control" name="id_area" id="id_area">
                    <option>Selecione</option>
                    <c:forEach items="${areas}" var="area">
                        <option value="${area.id}">${area.nome}</option>
                    </c:forEach>
                </select>
                <h4>Data do Agendamento:</h4>
                <input type="date" name="data" id="data" class="form-control"/>
                
                <h4>Hora do Agendamento:</h4>
                <input type="Time" name="hora" id="hora" class="form-control"/>
                <br />
                <input type="submit" value="Agendar" class="btn btn-lg btn-primary btn-block width40 center-block"/>
            </form>
            
        </div>
        
    </body>
</html>
