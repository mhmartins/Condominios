/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.ReuniaoBC;
import Exception.BcException;
import Model.Morador;
import Model.Reuniao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
public class CadastrarReuniaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/cadastrar-reuniao.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reuniao reuniao;
        reuniao = new Reuniao();
        reuniao.setAssunto(request.getParameter("assunto"));
        reuniao.setPauta(request.getParameter("pauta"));

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
        if (ReuniaoBC.getInstance().cadastrarReuniao(reuniao)) {
            rd = request.getRequestDispatcher("jsp/agenda-reuniao.jsp");
        } else {
            rd = request.getRequestDispatcher("jsp/cadastrar-reuniao.jsp");
        }
        rd.forward(request, response);
    }
}

/*@Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 Reuniao reuniao;
 reuniao = new Reuniao();
 reuniao.setAssunto(request.getParameter("assunto"));
 reuniao.setPauta(request.getParameter("pauta"));

 SimpleDateFormat sdf;
 sdf = new SimpleDateFormat("dd/MM/yyyy");
 try {
 Date dataReuniao = sdf.parse(request.getParameter("dataReuniao"));
 dataReuniao.setHours(Integer.parseInt(request.getParameter("horaReuniao")));
 reuniao.setData(dataReuniao);
 } catch (ParseException e) {
 }

 Morador morador;
 morador = (Morador) request.getSession().getAttribute("morador");
 reuniao.setMorador(morador);

 RequestDispatcher rd;
 if(ReuniaoBC.getInstance().cadastrarReuniao(reuniao)){
 rd  = request.getRequestDispatcher("jsp/agenda-reuniao.jsp");
 }else {
 rd = request.getRequestDispatcher("jsp/cadastrar-reuniao.jsp");
 }
 rd.forward(request, response);
 }*/
