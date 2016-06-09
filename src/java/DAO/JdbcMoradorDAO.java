/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IMoradorDAO;
import Model.Enum.TipoMorador;
import Model.Morador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuka
 */
public class JdbcMoradorDAO implements IMoradorDAO{
    
    private Connection connection;
    
    public JdbcMoradorDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean verificaLogin(Morador morador) {
        
        try {
            String sql = "SELECT * FROM Morador WHERE Login = ? and Senha = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setString(1, morador.getLogin());
            ps.setString(2, morador.getSenha());
            rs = ps.executeQuery();
            if(rs.next()){
                populateUsuario(morador, rs);
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente "+ex.getMessage());
        }
    }
    
    public void populateUsuario(Morador morador, ResultSet rs) throws SQLException{
        if(TipoMorador.CONDOMINO.getTipo() == rs.getString("Tipo").charAt(0) ){
            morador.setTipoMorador(TipoMorador.CONDOMINO);
        }else {
            morador.setTipoMorador(TipoMorador.SINDICO);
        }
        morador.setNumApt(rs.getInt("Apartamento"));
    }
    
    
    
}
