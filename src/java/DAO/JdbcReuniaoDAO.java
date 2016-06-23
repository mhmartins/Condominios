/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IReuniao;
import Model.Reuniao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author prisley.costa
 */
public class JdbcReuniaoDAO implements IReuniao{
    
    private Connection connection;
    
    public JdbcReuniaoDAO(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public boolean cadastrarReuniao(Reuniao reuniao) {
        try {
            PreparedStatement ps;        
            String sql = "INSERT INTO Reuniao (assunto, pauta, morador, dataReuniao) VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, reuniao.getAssunto());
            ps.setString(2, reuniao.getPauta());
            ps.setInt(3, reuniao.getMorador().getId());
            java.sql.Date dateSql = new java.sql.Date(reuniao.getData().getTime());
            ps.setDate(4, dateSql);

            if(ps.executeUpdate() == 1){
                
                return true;
            }else {
                return false;
            }    
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente "+ex.getMessage());
        }        
    }
    
}
