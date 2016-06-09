<%-- 
    Document   : cadastrar-estoque
    Created on : 09/06/2016, 13:34:29
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
                    <li class="active"><a href="Estoque">Controle de Estoque</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <!-- -->
        <div class="container" style="width:40%">
            <form action="" method="POST">                
                <h4>Nome:</h4>
                <input type="text" name="nome" id="nome" class="form-control"/>
                <h4>Descrição (Breve)</h4>
                <input type="text" name="descricao" id="descricao" class="form-control"/>
                <h4>Quantidade</h4>
                <input type="number" name="quantidade" id="quantidade" class="form-control width40"/>
                <br /><input type="submit" value="Cadastrar" class="btn btn-lg btn-primary btn-block width40 center-block"/>
            </form>
            
        </div>
    </body>
</html>