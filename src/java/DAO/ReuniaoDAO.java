/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.IReuniao;
import Model.Reuniao;
import java.util.List;
/**
 *
 * @author prisley.costa
 */
public class ReuniaoDAO implements IReuniao {

    public static ReuniaoDAO instance;
   
    public static ReuniaoDAO getInstance() { 
        if(instance == null){
            instance = new ReuniaoDAO();
        }
        return instance;
    }

    @Override
    public boolean cadastrarReuniao(Reuniao reuniao) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IReuniao iReuniao = iManager.getReuniaoDAO();
        return iReuniao.cadastrarReuniao(reuniao);
    }

    @Override
    public List<Reuniao> visualizarReuniao() {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IReuniao iReuniao = iManager.getReuniaoDAO();
        return iReuniao.visualizarReuniao();
    }
    
}
