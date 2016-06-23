/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IAgendamentoDAO;
import Model.Agendamento;
import Model.Area;
import Model.Enum.TipoMorador;
import Model.Morador;
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
public class JdbcAgendamentoDAO implements IAgendamentoDAO{

    Connection connection;
    
    public JdbcAgendamentoDAO(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public boolean realizaAgendamento(Agendamento agendamento) {
        try {
            PreparedStatement ps;
           // String sql = "INSERT INTO AgendamentoArea (id_morador,id_area,data) VALUES (?,?,?)";
            String sql = "INSERT INTO AgendamentoArea (id_morador,id_area) VALUES (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, agendamento.getMorador().getId());
            ps.setInt(2, agendamento.getArea().getId());
           // ps.setDate(3, new java.sql.Date(agendamento.getData().getTime()));
            
            if(ps.executeUpdate() == 1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente"+ex.getMessage());
                    
                   
        }
        
        
    }

    @Override
    public List<Agendamento> getAgendamentos() {
        try {
            PreparedStatement ps;
            ResultSet rs;
            List<Agendamento> agendamentos = null;
            agendamentos = new ArrayList<Agendamento>();
            
            String sql = "SELECT "
                            + " mo.login,mo.Apartamento,mo.Tipo, mo.Id as idMorador, " 
                            +"	aa.id as idAgendamento, aa.data, " 
                            +"	ar.id as idArea, ar.nome as nomeArea, ar.descricao as descArea" 
                        + " FROM " 
                        + "	AgendamentoArea aa " 
                        + " INNER JOIN Morador mo on mo.Id = aa. id_morador " 
                        + " INNER JOIN Area ar on ar.id = aa.id_area";
            
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                agendamentos.add(populateAgendamento(rs));
            }
            return agendamentos;
        }catch(SQLException e){
            throw new DaoException("Erro com o banco de dados, tente novamente");
        }
    }
    public Agendamento populateAgendamento(ResultSet rs) throws SQLException {
        Agendamento agendamento;
        Morador morador;
        Area area;
        morador = new Morador(rs.getString("login"));
        morador.setId(rs.getInt("idMorador"));
        morador.setNumApt(rs.getInt("Apartamento"));
        if(rs.getString("Tipo").charAt(0) == TipoMorador.SINDICO.getTipo()){
            morador.setTipoMorador(TipoMorador.SINDICO);
        }else {
            morador.setTipoMorador(TipoMorador.CONDOMINO);
        }
        area = new Area();
        area.setId(rs.getInt("idArea"));
        area.setNome(rs.getString("nomeArea"));
        area.setDescricao(rs.getString("descArea"));
        
        agendamento = new Agendamento(area, morador);
        //falta data
        //agendamento.setData(rs.ge);
        
        return agendamento;
    }
    
}
