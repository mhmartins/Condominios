/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author desenvolvimento
 */
public class Produto {
    
    private String nome, descricao;
    private int quantidade;
    private int id;

    
    
    public Produto(){
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
