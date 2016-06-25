<%-- 
    Document   : mural-inicio
    Created on : 23/06/2016, 12:49:23
    Author     : desenvolvimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                    <li><a href="Estoque">Estoque</a></li>
                    <li ><a href="AreasComuns">Áreas Comuns</a></li>
                    <li  class="active" ><a href="Mural">Mural de Comunicação</a></li>
                    <li><a href="ReuniaoInicio">Agendar Reunião</a></li>
                    <li><a href="MoradorInicio">Cadastrar Morador</a></li>
                    <li><a href="VisualizarSolicitacao">Solicitações</a></li>
                    <li><a href="Financeiro">Financeiro</a></li>
                    <li><a href="Logoff">Logoff</a></li>
                </ul>
              </div><!--/.nav-collapse -->
          </div>
        </nav>
        <div class="container">
        
            <center>
            <a href="AdicionarMural"><button class="btn btn-lg btn-primary">Adicionar Informação</button></a>
            <a href="VisualizarMural"><button class="btn btn-lg btn-primary">Abrir Mural</button></a>
        </center>
    </div>

    </body>
</html>
