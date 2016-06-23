/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IAreaDAO;
import Interfaces.IDaoManager;
import Interfaces.IMoradorDAO;
import Model.Area;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class AreaDAO implements IAreaDAO{

    public static AreaDAO instance;
    public static AreaDAO getInstance(){
        if(instance == null){
            instance = new AreaDAO();
        }
        return instance;
    }
    
    @Override
    public List<Area> getAreas() {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IAreaDAO areaDAO = iManager.getAreaDAO();
        
        return areaDAO.getAreas();
    }

    @Override
    public Area getAreaById(int id) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IAreaDAO areaDAO = iManager.getAreaDAO();
        
        return areaDAO.getAreaById(id);
    }
    
}
