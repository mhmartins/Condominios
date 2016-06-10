/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Exception.BcException;
import Model.Morador;
import Model.Produto;
import Model.Reuniao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
@WebServlet(name = "CadastrarReuniaoServlet", urlPatterns = {"/CadastrarReuniao"})
public class CadastrarReuniao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/cadastrar-reuniao.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        Reuniao reuniao;
        reuniao = new Reuniao();
        reuniao.setAssunto(request.getParameter("nome"));
        reuniao.setPauta(request.getParameter("descricao"));
        
       
        
         try { 
            String dataString = request.getParameter("dataReuniao");
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date data = df.parse(dataString);
            reuniao.setData(data);
            
         } catch (ParseException ex) {
            ex.printStackTrace();
            throw new BcException(ex.getMessage());
        }
       
        
        Morador morador;
        morador = (Morador) request.getSession().getAttribute("morador");
        reuniao.setMorador(morador);

        RequestDispatcher rd;
    }
}