/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IInformacaoDAO;
import Model.Enum.TipoMorador;
import Model.Informacao;
import Model.Morador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class JdbcInformacaoDAO implements IInformacaoDAO{
    
    private Connection connection;
    
    
    public JdbcInformacaoDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Informacao> getInformacoesAtivas() {
        try {
        PreparedStatement ps;
        ResultSet rs;
        List<Informacao> informacoes = new ArrayList<Informacao>();
        String sql = "SELECT "
                + "     inf.id as idInf,inf.titulo,inf.informacao, mor.Id as idMorador, mor.Login, mor.Tipo "
                + " FROM "
                + "     Informacao inf "
                + "INNER JOIN "
                + "     Morador mor ON mor.id = inf.id_morador "
                + " WHERE "
                + "     inf.status = 'A' order by inf.id desc limit 10"
                + "";
        
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            informacoes.add(populateInformacao(rs));
        }
        return informacoes;
        }catch(SQLException e){
            throw new DaoException("Erro com o banco de dados, tente novamente"+e.getMessage());
        }
    }

    @Override
    public boolean cadastraInformacao(Informacao informacao) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Informacao (titulo,informacao,id_morador) VALUES (?,?,?)";
            ps = connection.prepareCall(sql);
            ps.setString(1, informacao.getTitulo());
            ps.setString(2, informacao.getInformacao());
            ps.setInt(3,informacao.getMorador().getId());
            if(ps.executeUpdate() == 1){
                return true;
            }else {
                return false;
            }
        }catch(SQLException e){
            throw new DaoException("Erro com o banco de dados, tente novamente");
        }
       
    }
    
    public Informacao populateInformacao(ResultSet rs) throws SQLException{
        Informacao informacao = new Informacao();
        Morador morador = new Morador(rs.getString("login"));
        morador.setId(rs.getInt("idMorador"));
        if(rs.getString("tipo").charAt(0) == TipoMorador.SINDICO.getTipo()){
           morador.setTipoMorador(TipoMorador.SINDICO);
        }else {
            morador.setTipoMorador(TipoMorador.CONDOMINO);
        }
        informacao.setMorador(morador);        
        informacao.setId(rs.getInt("idInf"));
        informacao.setTitulo(rs.getString("titulo"));
        informacao.setInformacao(rs.getString("informacao"));
        return informacao;
    }
    

}
