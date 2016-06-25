/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IAcrescimoDAO;
import Interfaces.IDaoManager;
import Model.Acrescimo;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class AcrescimoDAO implements IAcrescimoDAO{

    public static AcrescimoDAO instance;
    public static AcrescimoDAO getInstance(){
        if(instance == null){
            instance = new AcrescimoDAO();
        }
        return instance;
    }
    
    
    @Override
    public boolean cadastrarAcrescimo(Acrescimo acrescimo) {
       IDaoManager iManager = new JdbcDaoManager();
       iManager.iniciar();
       IAcrescimoDAO acrescimoDAO = iManager.getAcrescimoDAO();
       return acrescimoDAO.cadastrarAcrescimo(acrescimo);
    }

    @Override
    public List<Acrescimo> getAcrescimos() {
       IDaoManager iManager = new JdbcDaoManager();
       iManager.iniciar();
       IAcrescimoDAO acrescimoDAO = iManager.getAcrescimoDAO();
       return acrescimoDAO.getAcrescimos();
    }

    @Override
    public boolean removerAcrescimo(Acrescimo acrescimo) {
       IDaoManager iManager = new JdbcDaoManager();
       iManager.iniciar();
       IAcrescimoDAO acrescimoDAO = iManager.getAcrescimoDAO();
       return acrescimoDAO.removerAcrescimo(acrescimo);
    }

    @Override
    public Acrescimo getAcrescimoById(int id) {
       IDaoManager iManager = new JdbcDaoManager();
       iManager.iniciar();
       IAcrescimoDAO acrescimoDAO = iManager.getAcrescimoDAO();
       return acrescimoDAO.getAcrescimoById(id);
    }
    
}
