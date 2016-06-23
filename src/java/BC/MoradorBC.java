/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.MoradorDAO;
import Exception.BcException;
import Model.Morador;

/**
 *
 * @author Tuka
 */
public class MoradorBC {

    public static MoradorBC instance;

    public static MoradorBC getInstance() {
        if(instance == null){
            instance = new MoradorBC();
        }
        return instance;
    }

    public boolean verificaLogin(Morador morador){
        if(morador.getLogin().equals("") || morador.getSenha().equals("") || morador.getLogin() == null || morador.getSenha() == null){
            throw new BcException("Morador Inválido");
        }
        return MoradorDAO.getInstance().verificaLogin(morador);
    }
}