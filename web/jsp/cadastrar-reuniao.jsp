<%-- 
    Document   : cadastrar-reuniao
    Created on : 09/06/2016, 18:04:32
    Author     : prisley.costa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Reunião</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <!-- -->
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
                    <li><a href="Logoff">Logoff</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container" style="width:40%">
            <form action="" method="POST">                
                <h4>Assunto:</h4>
                <input type="text" name="assunto" id="assunto" class="form-control"/>
                <h4>Pauta Reunião:</h4>
                <input type="text" name="pauta" id="pauta" class="form-control"/>
                <h4>Data da Reunião:</h4>
                <input type="date" name="dataReuniao" id="dataReuniao" class="form-control"/>
                <h4>Hora Reunião</h4>
                <input type="time" name="horaReuniao" id="horaReuniao" class="form-control"/>
                <br /><input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block width40 center-block"/>
            </form>
        </div>
    </body>
</html>
