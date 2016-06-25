/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.ISolicitacao;
import Model.Morador;
import Model.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public class JdbcSolicitacaoDAO implements ISolicitacao {

    private Connection connection;

    public JdbcSolicitacaoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean cadastrarSolicitacao(Solicitacao solicitacao) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Solicitacao ("
                    + "id_morador, "
                    + "status, "
                    + "dataAbertura) "
                    + "VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, solicitacao.getMorador().getId());
            ps.setInt(2, solicitacao.getStatus());
            java.sql.Date dateSql = new java.sql.Date(solicitacao.getDataAbertura().getTime());
            ps.setDate(3, dateSql);

            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }


    @Override
    public Morador getMoradorById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean responderSolicitacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSolicitacaoById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Solicitacao> getSolicitacoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
