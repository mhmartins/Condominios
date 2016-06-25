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

/**
 *
 * @author Tobias
 */
public class CadastrarAcrescimoServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        RequestDispatcher rd = request.getRequestDispatcher("jsp/novo-acrescimo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Acrescimo acrescimo = new Acrescimo();
        acrescimo.setDescricao(request.getParameter("descricao"));
        acrescimo.setValor(Double.valueOf(request.getParameter("valor")));
        
        RequestDispatcher rd;
        if(ControleFinanceiroBC.getInstance().cadastrarAcrescimo(acrescimo)){
            rd = request.getRequestDispatcher("jsp/novo-acrescimo.jsp");
        }else {
            rd = request.getRequestDispatcher("jsp/financeiro-inicio.jsp");
        }
        
        rd.forward(request, response);
       
    }

  
}
