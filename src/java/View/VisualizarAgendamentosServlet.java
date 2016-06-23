/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.AgendamentoBC;
import Model.Agendamento;
import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizarAgendamentosServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Agendamento> agendamentos = AgendamentoBC.getInstance().getAgendamentos();
        request.setAttribute("agendamentos", agendamentos);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/listar-agendamento.jsp");
        rd.forward(request, response);
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
