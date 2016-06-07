/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.IMoradorDAO;
import Model.Enum.TipoMorador;
import Model.Morador;

/**
 *
 * @author Tuka
 */
public class MoradorDAO implements IMoradorDAO{

    public static MoradorDAO instance;
    public static MoradorDAO getInstance(){
        if(instance == null){
            instance = new MoradorDAO();
        }
        return instance;
    }
    
    
    
    @Override
    public boolean verificaLogin(Morador morador) {
     
          IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IMoradorDAO moradorDAO = iManager.getMoradorDAO();
        return moradorDAO.verificaLogin(morador);
    }
    
}
