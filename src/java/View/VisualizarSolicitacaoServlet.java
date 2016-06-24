/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.SolicitacaoBC;
import Model.Solicitacao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
public class VisualizarSolicitacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Solicitacao> solicitacoes = SolicitacaoBC.getInstance().getSolicitacoes();// = ReuniaoBC.getInstance().visualizarReuniao();
        request.setAttribute("solicitacoes", solicitacoes);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/listar-solicitacoes.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}