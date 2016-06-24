
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


public class PrincipalServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Comentario
        RequestDispatcher rd;
        
        Morador morador = (Morador)request.getSession().getAttribute("morador");
        if(morador != null){
            if(morador.getTipoMorador() == TipoMorador.CONDOMINO){
                rd = request.getRequestDispatcher("jsp/painel-condomino.jsp");    
            }else {
                rd = request.getRequestDispatcher("jsp/painel-sindico.jsp");
            }
        }else {
            rd = request.getRequestDispatcher("jsp/Inicio.jsp");
        }
       
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
                rd = request.getRequestDispatcher("jsp/painel-condomino.jsp");    
            }else {
                rd = request.getRequestDispatcher("jsp/painel-sindico.jsp");
            }
            
           
        }else {
            rd = request.getRequestDispatcher("jsp/Inicio.jsp");
            
        }
        
        MuralInformacoes mural = MuralInformacaoBC.getInstance().getMuralInformacao();
        request.setAttribute("mural", mural);
        rd.forward(request, response);
        
    }


}
