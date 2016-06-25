<%-- 
    Document   : cadastrar-solicitacao
    Created on : 24/06/2016, 16:08:09
    Author     : prisley.costa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Solicitação</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
        <script>tinymce.init({selector: 'textarea'});</script>
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
                    <li><a href="ReuniaoInicio">Agendar Reunião</a></li>
                    <li  class="active"><a href="CadastrarSolicitacao">Cadastrar Solicitação</a></li>
                    <li><a href="Logoff">Logoff</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container" style="width:40%">
            <form action="" method="POST">                
                <h4>Titulo:</h4>
                <input type="text" name="titulo" id="titulo" class="form-control"/>
                <h4>Mensagem:</h4>
                <textarea rows="5" cols="50" name="texto" form=""></textarea>
                <br /><input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block width40 center-block"/>
            </form>
        </div>
    </body>
</html>
