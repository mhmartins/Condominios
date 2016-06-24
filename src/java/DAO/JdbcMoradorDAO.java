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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuka
 */
public class JdbcMoradorDAO implements IMoradorDAO {

    private Connection connection;

    public JdbcMoradorDAO(Connection connection) {
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
            if (rs.next()) {
                populateUsuario(morador, rs);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }

    public void populateUsuario(Morador morador, ResultSet rs) throws SQLException {
        if (TipoMorador.CONDOMINO.getTipo() == rs.getString("Tipo").charAt(0)) {
            morador.setTipoMorador(TipoMorador.CONDOMINO);
        } else {
            morador.setTipoMorador(TipoMorador.SINDICO);
        }
        morador.setNumApt(rs.getInt("Apartamento"));
        morador.setId(rs.getInt("id"));

    }

    @Override
    public boolean cadastrarMorador(Morador morador) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Morador ("
                    + "Login, "
                    + "Senha, "
                    + "Apartamento, "
                    + "Tipo) "
                    + "VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, morador.getLogin());
            ps.setString(2, morador.getSenha());
            ps.setInt(3, morador.getNumApt());
            ps.setString(4, String.valueOf(morador.getTipoMorador().getTipo()));

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
    public List<Morador> visualizarMoradores() {
        try {
            PreparedStatement ps;
            ResultSet rs;
            List<Morador> moradores = null;
            moradores = new ArrayList<Morador>();

            String sql = "SELECT "
                    + "Id, "
                    + "Login, "
                    + "Senha, "
                    + "Apartamento, "
                    + "Tipo "
                    + "from Morador "
                    + "where Tipo = 'C'";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                moradores.add(populateMorador(rs));
            }
            return moradores;
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }

    public Morador populateMorador(ResultSet rs) throws SQLException {
        Morador morador;
        morador = new Morador();
        morador.setId(rs.getInt("Id"));
        morador.setLogin(rs.getString("Login"));
        morador.setNumApt(rs.getInt("Apartamento"));
        morador.setSenha(rs.getString("Senha"));
        if (TipoMorador.CONDOMINO.getTipo() == rs.getString("Tipo").charAt(0)) {
            morador.setTipoMorador(TipoMorador.CONDOMINO);
        }
        return morador;

    }

    @Override
    public Morador getMoradorById(int id) {
        try {
            Morador morador = null;
            String sql = "SELECT * FROM Morador WHERE Id = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                morador = populateMorador(rs);
            }
            return morador;

        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }

    @Override
    public boolean updateMorador(Morador morador) {
        try {
            String sql = "UPDATE Morador SET Login = ?, Senha = ?, Apartamento = ? WHERE Id = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setString(1, morador.getLogin());
            ps.setString(2, morador.getSenha());
            ps.setInt(3, morador.getNumApt());
            ps.setInt(4, morador.getId());

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
    public boolean deleteMoradorById(int id) {
        try {
            String sql = "DELETE Morador WHERE Id = ?";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente " + ex.getMessage());
        }
    }
}
