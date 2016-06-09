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
public class CadastrarProdutoServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            RequestDispatcher rd = request.getRequestDispatcher("jsp/cadastrar-estoque.jsp");
            rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto produto;
        produto = new Produto();
        produto.setNome(request.getParameter("nome"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        
        RequestDispatcher rd;
        
        if(ProdutoBC.getInstance().cadastrarProduto(produto)){
            rd  = request.getRequestDispatcher("Estoque");
        }else {
            rd = request.getRequestDispatcher("CadastrarProduto");
        }
        rd.forward(request, response);
    }

}
