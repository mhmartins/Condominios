/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.ProdutoDAO;
import Exception.BcException;
import Interfaces.IProdutoDAO;
import Model.Produto;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class ProdutoBC implements IProdutoDAO{
    
    private ProdutoBC() {
    }
    
   public static ProdutoBC instance;
   
   public static ProdutoBC getInstance() { 
       if(instance == null){
           instance = new ProdutoBC();
       }
       return instance;
   }

    @Override
    public List<Produto> getProdutos() {
        return ProdutoDAO.getInstance().getProdutos();
    }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        if(produto.getNome().trim().equals("") || produto.getNome() == null){
            throw new BcException("Produto sem nome");
        }else if (produto.getDescricao().trim().equals("") || produto.getDescricao() == null) {
            throw new BcException("Produto sem descrição");
        }else if (produto.getQuantidade() <= 0){
            throw new BcException("Quantidade inválida");
        }else {
            return ProdutoDAO.getInstance().cadastrarProduto(produto);
        }
    }
}
