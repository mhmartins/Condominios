/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Enum.TipoMorador;

/**
 *
 * @author Tuka
 */
public class Morador {
    
    private int id;
    private int numApt;
    private String login,senha;
    private TipoMorador tipoMorador;

    public Morador() {
        
    }
    
    public Morador(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public Morador(String login){
        this.login = login;
    }
    
    public int getNumApt() {
        return numApt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumApt(int numApt) {
        this.numApt = numApt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoMorador getTipoMorador() {
        return tipoMorador;
    }

    public void setTipoMorador(TipoMorador tipoMorador) {
        this.tipoMorador = tipoMorador;
    }
    
    
   
    
}
