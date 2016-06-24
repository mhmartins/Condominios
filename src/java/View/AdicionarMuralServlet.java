/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.MuralInformacaoBC;
import Model.Informacao;
import Model.Morador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarMuralServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("jsp/adicionar-mural.jsp");
        rd.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Informacao informacao = new Informacao();
        informacao.setTitulo(request.getParameter("titulo"));
        informacao.setInformacao(request.getParameter("informacao"));
        informacao.setMorador((Morador)request.getSession().getAttribute("morador"));
        
        RequestDispatcher rd;
        if(MuralInformacaoBC.getInstance().cadastraInformacao(informacao)){
            rd = request.getRequestDispatcher("jsp/mural-inicio.jsp");
        }else {
            rd = request.getRequestDispatcher("jsp/adicionar-mural.jsp");
        }
        
        rd.forward(request, response);
        
        
        

    }
}
