/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.AgendamentoBC;
import BC.AreaBC;
import Model.Agendamento;
import Model.Area;
import Model.Morador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author desenvolvimento
 */
public class AgendarAreaServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/agendar-area.jsp");
        
        List<Area> areas = AreaBC.getInstance().getAreas();
        request.setAttribute("areas", areas);
        
        
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Area area = AreaBC.getInstance().getAreaById(Integer.valueOf(request.getParameter("id_area")));
        Agendamento agendamento;
        agendamento = new Agendamento(area, (Morador) request.getSession().getAttribute("morador"));
        RequestDispatcher rd;
        if(AgendamentoBC.getInstance().realizaAgendamento(agendamento)){
            rd = request.getRequestDispatcher("jsp/areas-inicio.jsp");
        }else {
            rd = request.getRequestDispatcher("jsp/agendar-area.jsp");
        }
        
        rd.forward(request, response);
        
    }

}
