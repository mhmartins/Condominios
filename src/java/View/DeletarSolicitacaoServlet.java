/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.SolicitacaoBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
public class DeletarSolicitacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        PrintWriter out = response.getWriter();
        
        SolicitacaoBC.getInstance().deleteSolicitacaoById(id);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("jsp/painel-sindico.jsp");
        out.println("<script type=\"text/javascript\">alert('Solicitacao deletada com Sucesso!')</script>");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}