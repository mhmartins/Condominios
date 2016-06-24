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
        RequestDispatcher rd = request.getRequestDispatcher("jsp/editar-morador.jsp");
        Morador morador = MoradorBC.getInstance().getMoradorById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("morador", morador);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Morador morador = new Morador();
        morador.setId(Integer.valueOf(request.getParameter("id")));
        morador.setLogin(request.getParameter("login"));
        morador.setNumApt(Integer.valueOf(request.getParameter("numApt")));
        morador.setSenha(request.getParameter("senha"));
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd;
        MoradorBC.getInstance().updateMorador(morador);
        rd = request.getRequestDispatcher("jsp/morador-inicio.jsp");

        rd.forward(request, response);
    }
}