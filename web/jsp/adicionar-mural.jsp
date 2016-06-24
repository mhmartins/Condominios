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
        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
        <script>tinymce.init({selector: 'textarea'});</script>
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
                        <li ><a href="AreasComuns">Áreas Comuns</a></li>
                        <li class="active" ><a href="Mural">Mural de Comunicação</a></li>
                        <li><a href="ReuniaoInicio">Agendar Reunião</a></li>
                        <li><a href="MoradorInicio">Cadastrar Morador</a></li>
                        <li><a href="VisualizarSolicitacao">Solicitações</a></li>
                        <li><a href="Logoff">Logoff</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container width40">
            <form action="" method="POST">
                <h4 class="text-justify">Título</h4>
                <input type="text" id="titulo" name="titulo" class="form-control" />
                <h4 class="text-justify">Informação</h4>
                <textarea id="informacao" name="informacao" rows="20"></textarea> 
                <br />
                <input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block width40 center-block"/>
            </form>

        </div>

    </body>
</html>
