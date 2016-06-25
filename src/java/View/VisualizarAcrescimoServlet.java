
package View;

import BC.ControleFinanceiroBC;
import Model.Acrescimo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizarAcrescimoServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Acrescimo> acrescimos = ControleFinanceiroBC.getInstance().getAcrescimos();
        request.setAttribute("acrescimos", acrescimos);
        
        RequestDispatcher rd = request.getRequestDispatcher("jsp/listar-acrescimos.jsp");
        rd.forward(request, response);
        
        
       
    }

  

}
