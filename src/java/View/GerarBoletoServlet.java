/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.ControleFinanceiroBC;
import BC.MoradorBC;
import Model.Morador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GerarBoletoServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("jsp/boleto-inicio.jsp");
        rd.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        List<Morador> moradores = MoradorBC.getInstance().visualizarMoradores();
        if(ControleFinanceiroBC.getInstance().gerarBoleto(moradores)){
            rd = request.getRequestDispatcher("jsp/financeiro-inicio.jsp");
        }else {
            rd = request.getRequestDispatcher("jsp/boleto-inicio.jsp");
        }
        
    }

}
