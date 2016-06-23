<%-- 
    Document   : teste
    Created on : 06/06/2016, 23:03:29
    Author     : Tuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
       
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/signin.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <center>
            
            <form action="Principal" method="POST" class="form-signin">
            <h2 class="form-signin-heading">Logar</h2>
            <table>
                <tr>
                    <td><input type="text" name="login" placeholder="Login" id="login" class="form-control" /> </td>
                </tr>
                <tr>
                    <td><input type="password" name="senha" placeholder="Senha" id="senha" class="form-control" /> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Logar" class="btn btn-lg btn-primary btn-block" /></td>
                </tr>
            </table>
        </form>
        </center>
    </body>
</html>