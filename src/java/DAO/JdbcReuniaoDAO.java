/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IReuniao;
import Model.Enum.TipoMorador;
import Model.Morador;
import Model.Reuniao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            String sql = "INSERT INTO Reuniao ("
                        + "assunto, "
                        + "pauta, "
                        + "idMorador, "
                        + "dataReuniao) "
                        + "VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, reuniao.getAssunto());
            ps.setString(2, reuniao.getPauta());
            ps.setInt(3, reuniao.getMorador().getId());
            java.sql.Date dateSql = new java.sql.Date(reuniao.getData().getTime());
            ps.setDate(4, dateSql);

            if(ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }    
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente "+ex.getMessage());
        }        
    }

    @Override
    public List<Reuniao> visualizarReuniao() {
        try {
            PreparedStatement ps;
            ResultSet rs;
            List<Reuniao> reunioes = null;
            reunioes = new ArrayList<Reuniao>();
            
            String sql = "SELECT "
                       + "a.assunto, "
                       + "a.pauta, "
                       + "a.dataReuniao, "
                       + "b.login, "
                       + "b.Apartamento, "
                       + "b.Tipo, "
                       + "b.Id as idMorador " 
                       + "from Reuniao as a "
                       + "inner join Morador as b "
                       + "on a.idMorador = b.id";
            
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                reunioes.add(populateReuniao(rs));
            }
            return reunioes;
        }catch(SQLException ex){
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }
    public Reuniao populateReuniao(ResultSet rs) throws SQLException {
        Reuniao reuniao;
        reuniao = new Reuniao();
        reuniao.setAssunto(rs.getString("assunto"));
        reuniao.setPauta(rs.getString("pauta"));
        reuniao.setData(rs.getDate("dataReuniao"));
        Morador morador;
        morador = new Morador(rs.getString("login"));
        morador.setId(rs.getInt("idMorador"));
        morador.setNumApt(rs.getInt("Apartamento"));
        if(rs.getString("Tipo").charAt(0) == TipoMorador.SINDICO.getTipo()) {
            morador.setTipoMorador(TipoMorador.SINDICO);
        } else {
            morador.setTipoMorador(TipoMorador.CONDOMINO);
        }
        reuniao.setMorador(morador);
        return reuniao;
    }
}