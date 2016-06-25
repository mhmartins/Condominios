/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IMensagemDAO;
import Model.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author prisl
 */
public class JdbcMensagemDAO implements IMensagemDAO {

    private Connection connection;

    public JdbcMensagemDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean cadastrarMsg(Mensagem mensagem) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Mensagem (tituloMsg, textoMsg, idSolicitacao) VALUES (?,?,?)";
            ps = connection.prepareCall(sql);
            ps.setString(1, mensagem.getTitulo());
            ps.setString(2, mensagem.getTexto());
            ps.setInt(3, mensagem.getSolicitacao().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new DaoException("Erro com o banco de dados, tente novamente");
        }

    }
}
