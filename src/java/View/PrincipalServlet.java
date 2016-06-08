
package View;

import BC.MoradorBC;
import Model.Enum.TipoMorador;
import Model.Morador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrincipalServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Comentario
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Inicio.jsp");
        rd.forward(request, response);
        
        
        
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Morador morador;
        morador = new Morador(request.getParameter("login"),request.getParameter("senha"));
        RequestDispatcher rd;
        if(MoradorBC.getInstance().verificaLogin(morador)){
            
            request.getSession().setAttribute("morador", morador);
            if(morador.getTipoMorador() == TipoMorador.CONDOMINO){
                rd = request.getRequestDispatcher("WEB-INF/jsp/painel-condomino.jsp");    
            }else {
                rd = request.getRequestDispatcher("WEB-INF/jsp/painel-sindico.jsp");
            }
            
            rd.forward(request, response);
        }else {
            rd = request.getRequestDispatcher("WEB-INF/jsp/Inicio.jsp");
            rd.forward(request, response);
        }
        
        
    }


}
