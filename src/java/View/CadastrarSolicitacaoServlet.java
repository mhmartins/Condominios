/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.SolicitacaoBC;
import Model.Morador;
import Model.Solicitacao;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
public class CadastrarSolicitacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/cadastrar-solicitacao.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Morador morador;
        morador = (Morador) request.getSession().getAttribute("morador");

        Solicitacao solic;
        solic = new Solicitacao();

        solic.setMorador(morador);
        solic.setTexto(request.getParameter("texto"));
        solic.setTitulo(request.getParameter("titulo"));
        solic.setStatus("Aberto"); //mudar isso para um int para determinar o status
        solic.setDataAbertura(new Date());

        RequestDispatcher rd;

        SolicitacaoBC.getInstance().cadastrarSolicitacao(solic);
        rd = request.getRequestDispatcher("jsp/painel-sindico.jsp");
        rd.forward(request, response);
    }
}
