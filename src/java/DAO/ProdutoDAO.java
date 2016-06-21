/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.IMoradorDAO;
import Interfaces.IProdutoDAO;
import Model.Morador;
import Model.Produto;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class ProdutoDAO implements IProdutoDAO{

    @Override
    public List<Produto> getProdutos() {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IProdutoDAO produtoDAO = iManager.getProdutoDAO();
        return produtoDAO.getProdutos();
    }
    
    public static ProdutoDAO instance;
    
       public static ProdutoDAO getInstance(){
           if(instance == null){
               instance = new ProdutoDAO();
           }
           return instance;
       }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IProdutoDAO produtoDAO = iManager.getProdutoDAO();
        return produtoDAO.cadastrarProduto(produto);    
    }

    @Override
    public Produto getProdutoById(int id) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IProdutoDAO produtoDAO = iManager.getProdutoDAO();
        return produtoDAO.getProdutoById(id);
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IProdutoDAO produtoDAO = iManager.getProdutoDAO();
        return produtoDAO.atualizarProduto(produto);
    }
    
    
    

    
}
