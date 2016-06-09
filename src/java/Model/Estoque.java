/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class Estoque {
    
    
    private List<Produto> produtos;
    
    
    public Estoque(){
        produtos = new ArrayList<Produto>();
    }
    
    public void atualizarQuantidadeProduto(int quantidade, int pos){
        if(quantidade <= 0){
            produtos.remove(pos);
        }else {
            produtos.get(pos).setQuantidade(quantidade);
        }
    }
    
   public List<Produto> getProdutos(){
       return produtos;
   }
   
   public void addProduto(Produto produto){
       this.produtos.add(produto);
   }
   
   public void setProdutos(List<Produto> produtos){
       this.produtos = produtos;
   }
    
    
}
