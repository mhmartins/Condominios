<%-- 
    Document   : teste
    Created on : 06/06/2016, 23:03:29
    Author     : Tuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <center>
            <form action="Principal" method="POST">
            <table>
                <tr>
                    <td>Login:</td>
                    <td><input type="text" name="login" id="login" /> </td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td><input type="password" name="senha" id="senha" /> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Logar" /></td>
                </tr>
            </table>
        </form>
        </center>
        
       
    </body>
</html>
