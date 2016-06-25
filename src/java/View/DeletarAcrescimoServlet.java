/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.ControleFinanceiroBC;
import Model.Acrescimo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeletarAcrescimoServlet extends HttpServlet {

   
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            RequestDispatcher rd;
            Acrescimo ac = ControleFinanceiroBC.getInstance().getAcrescimoById(Integer.valueOf(request.getParameter("id")));
            if(ControleFinanceiroBC.getInstance().removerAcrescimo(ac)){
                rd = request.getRequestDispatcher("jsp/financeiro-inicio.jsp");
            }else {
                rd = request.getRequestDispatcher("jsp/VisualizarAcrescimo.jsp");
            }
            rd.forward(request, response);
    }

 
    
}
