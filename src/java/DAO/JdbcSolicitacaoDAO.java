/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BC.MensagemBC;
import Exception.DaoException;
import Interfaces.ISolicitacao;
import Model.Mensagem;
import Model.Morador;
import Model.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            ResultSet rs;
            PreparedStatement ps;
            String sql = "INSERT INTO Solicitacao ("
                    + "id_morador, "
                    + "status, "
                    + "dataAbertura) "
                    + "VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, solicitacao.getMorador().getId());
            ps.setInt(2, solicitacao.getStatus());
            java.sql.Date dateSql = new java.sql.Date(solicitacao.getDataAbertura().getTime());
            ps.setDate(3, dateSql);

            if (ps.executeUpdate() == 1) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    solicitacao.setId(rs.getInt(1));
                    for (Mensagem msg : solicitacao.getMensagens()) {
                        MensagemBC.getInstance().cadastrarMsg(msg);
                    }
                }
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
        try {
            PreparedStatement ps;
            ResultSet rs;
            List<Solicitacao> solicitacoes = null;
            solicitacoes = new ArrayList<Solicitacao>();

            String sql = "SELECT "
                    + "a.* "
                    + "from Solicitacao as a ";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                solicitacoes.add(populateReuniao(rs));
            }
            return solicitacoes;
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }

    public Solicitacao populateReuniao(ResultSet rs) throws SQLException {

        return new Solicitacao();
    }
}
