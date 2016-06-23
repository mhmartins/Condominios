<%-- 
    Document   : agenda-reuniao
    Created on : 09/06/2016, 17:51:33
    Author     : prisley.costa
--%>

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
                    <li class="active"><a href="ReuniaoInicio">Agendar Reunião</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <center>
                <a href="CadastrarReuniao"><button class="btn btn-lg btn-primary">Agendar Reuniões</button></a>
                <a href="VisualizarReuniao"><button class="btn btn-lg btn-primary">Visualizar Reuniões</button></a>
            </center>
        </div>
    </body>
</html>
