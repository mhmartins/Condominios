/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import java.sql.Connection;
import Interfaces.IAcrescimoDAO;
import Model.Acrescimo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class JdbcAcrescimoDAO implements IAcrescimoDAO {
    
    private Connection connection;
    
    public JdbcAcrescimoDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean cadastrarAcrescimo(Acrescimo acrescimo) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Acrescimo (descricao,valor) VALUES (?,?)";
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, acrescimo.getDescricao());
            ps.setDouble(2, acrescimo.getValor());
            if(ps.executeUpdate() == 1){
                return true;
            }else {
                return false;
            }
        }catch(SQLException e){
            throw new DaoException("Problema com o banco de dados, tente novamente");
        }
    }

    @Override
    public List<Acrescimo> getAcrescimos() {
         try {
            List<Acrescimo> acrescimos = new ArrayList<Acrescimo>();
                    
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM Acrescimo WHERE status = 'A'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                acrescimos.add(populateAcrescimo(rs));
            }
            return acrescimos;
        }catch(SQLException e){
            throw new DaoException("Problema com o banco de dados, tente novamente "+e.getMessage());
        }
    }

    @Override
    public boolean removerAcrescimo(Acrescimo acrescimo) {
        try {
            PreparedStatement ps;
            String sql = "UPDATE Acrescimo SET status = 'I'WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, acrescimo.getId());
            
            if(ps.executeUpdate() == 1){
                return true;
            }else {
                return false;
            }
        }catch(SQLException e){
            throw new DaoException("Problema com o banco de dados, tente novamente");
        }
    }

    @Override
    public Acrescimo getAcrescimoById(int id) {
      try {
            Acrescimo acrescimo;
                    
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM Acrescimo WHERE ";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                return populateAcrescimo(rs);
            }
            return null;
        }catch(SQLException e){
            throw new DaoException("Problema com o banco de dados, tente novamente");
        }
    }
    
    public Acrescimo populateAcrescimo(ResultSet rs) throws SQLException {
        Acrescimo acrescimo = new Acrescimo();
        acrescimo.setDescricao(rs.getString("descricao"));
        acrescimo.setValor(rs.getDouble("valor"));
        acrescimo.setId(rs.getInt("id"));
        return acrescimo;
        
    }
    
}
