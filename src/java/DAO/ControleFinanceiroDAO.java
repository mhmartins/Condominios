/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IControleFinanceiro;
import Interfaces.IDaoManager;
import Model.Morador;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class ControleFinanceiroDAO implements IControleFinanceiro{

    public static ControleFinanceiroDAO instance;
    public static ControleFinanceiroDAO getInstance(){
        if(instance == null){
            instance = new ControleFinanceiroDAO();
        }
        return instance;
    }
    
    @Override
    public boolean gerarBoleto(List<Morador> moradores) {
        IDaoManager iManager = new JdbcDaoManager();
        iManager.iniciar();
        IControleFinanceiro controleDAO = iManager.getControleFinanceiroDAO();
        return controleDAO.gerarBoleto(moradores);
        
    }
    
}
