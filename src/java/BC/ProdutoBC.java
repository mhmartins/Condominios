/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

/**
 *
 * @author desenvolvimento
 */
public class ProdutoBC {
    
    private ProdutoBC() {
    }
    
   public static ProdutoBC instance;
   
   public static ProdutoBC getInstance() { 
       if(instance == null){
           instance = new ProdutoBC();
       }
       return instance;
   }
}
