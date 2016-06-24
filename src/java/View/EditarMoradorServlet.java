/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.MoradorBC;
import Model.Morador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisl
 */
public class EditarMoradorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/editar-produto.jsp");
        Morador morador = MoradorBC.getInstance().getMoradorById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("morador", morador);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Morador morador = new Morador();
        morador.setId(Integer.valueOf(request.getParameter("id")));
        morador.setLogin(request.getParameter("nome"));
        morador.setSenha(request.getParameter("descricao"));
        morador.setNumApt(Integer.valueOf(request.getParameter("quantidade")));
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd;
        if(MoradorBC.getInstance().updateMorador(morador)){
            rd = request.getRequestDispatcher("jsp/estoque-inicio.jsp");
            out.println("<script type=\"text/javascript\">alert('Produto atualizado com Sucesso!')</script>");
        }else {
            rd = request.getRequestDispatcher("jsp/editar-produto.jsp");
            morador = MoradorBC.getInstance().getMoradorById(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("produto", morador);
            out.println("<script type=\"text/javascript\">alert('Produto atualizado com Sucesso!')</script>");
        }
        out.close();
        rd.forward(request, response);
    }
}