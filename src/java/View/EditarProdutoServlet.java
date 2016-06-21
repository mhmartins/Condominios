/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BC.ProdutoBC;
import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author desenvolvimento
 */
public class EditarProdutoServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/editar-produto.jsp");
        Produto produto = ProdutoBC.getInstance().getProdutoById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("produto", produto);
        rd.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto produto = new Produto();
        produto.setId(Integer.valueOf(request.getParameter("id")));
        produto.setNome(request.getParameter("nome"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd;
        if(ProdutoBC.getInstance().atualizarProduto(produto)){
            rd = request.getRequestDispatcher("jsp/estoque-inicio.jsp");
            out.println("<script type=\"text/javascript\">alert('Produto atualizado com Sucesso!')</script>");
        }else {
            rd = request.getRequestDispatcher("jsp/editar-produto.jsp");
            produto = ProdutoBC.getInstance().getProdutoById(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("produto", produto);
            out.println("<script type=\"text/javascript\">alert('Produto atualizado com Sucesso!')</script>");
        }
        out.close();
        rd.forward(request, response);
    }

}
