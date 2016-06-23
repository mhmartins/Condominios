/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.AreaDAO;
import Exception.BcException;
import Interfaces.IAreaDAO;
import Model.Area;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class AreaBC implements IAreaDAO{
    
    public static AreaBC instance;
    public static AreaBC getInstance(){
        if(instance == null){
            instance = new AreaBC();
        }
        return instance;
    }
    
    private AreaBC(){
        
    }

    @Override
    public List<Area> getAreas() {
        return AreaDAO.getInstance().getAreas();
        
    }

    @Override
    public Area getAreaById(int id) {
        if(id < 0){
            throw new BcException("Area inválida");
        }else {
            return AreaDAO.getInstance().getAreaById(id);
        }
    }
    
}
