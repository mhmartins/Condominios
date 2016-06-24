/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.MoradorBC;
import BC.MuralInformacaoBC;
import Model.Enum.TipoMorador;
import Model.Morador;
import Model.MuralInformacoes;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisl
 */
public class CadastrarMoradorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/cadastrar-morador.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Morador morador;
        morador = new Morador();
        morador.setLogin(request.getParameter("login"));
        morador.setNumApt(Integer.parseInt(request.getParameter("numeroApt")));
        morador.setSenha(request.getParameter("senha"));
        morador.setTipoMorador(TipoMorador.CONDOMINO);
        RequestDispatcher rd;
        MoradorBC.getInstance().cadastrarMorador(morador);
        MuralInformacoes mural = MuralInformacaoBC.getInstance().getMuralInformacao();
        request.setAttribute("mural", mural);
        rd = request.getRequestDispatcher("jsp/morador-inicio.jsp");

        rd.forward(request, response);
    }
}