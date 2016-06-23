/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IAreaDAO;
import Model.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobias
 */
public class JdbcAreaDAO implements IAreaDAO {
    
    private Connection connection;
    
    public JdbcAreaDAO(Connection connection){
        this.connection = connection;   
    }

    @Override
    public List<Area> getAreas() {
        try {
            List<Area> areas = new ArrayList<Area>();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM Area";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                areas.add(populateArea(rs));
            }
            return areas;    
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados! Tente novamente");
        }
    }
    
    public Area populateArea(ResultSet rs) throws SQLException {
        Area area = new Area();
        area.setId(rs.getInt("id"));
        area.setNome(rs.getString("nome"));
        area.setDescricao(rs.getString("descricao"));
        return area;
    }

    @Override
    public Area getAreaById(int id) {
         try {
            Area area = null;
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM Area where id = ?";          
            
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            
            rs = ps.executeQuery();
            if(rs.next()){
                area = (populateArea(rs));
            }
            return area;
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados! Tente novamente");
        }
    }
    
}
