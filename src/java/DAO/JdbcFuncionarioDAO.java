/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IFuncionarioDAO;
import Model.Funcionario;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class JdbcFuncionarioDAO implements IFuncionarioDAO {
    
    private Connection connection;
    public JdbcFuncionarioDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Funcionario> getFuncionarios() {
       try {
           List<Funcionario> funcionarios = new ArrayList<Funcionario>();
           PreparedStatement ps;
           ResultSet rs;
           String sql = "SELECT * FROM Funcionario WHERE status = 'A' ";
           ps = connection.prepareCall(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               funcionarios.add(populateFuncionario(rs));
           }
           return funcionarios;
       }catch(SQLException e){
           throw new DaoException("Problema com o banco de dados, tente novamente");
       }
    }

    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Funcionario (login,senha) VALUES (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,funcionario.getLogin());
            ps.setString(2, funcionario.getSenha());
            
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
    public boolean removerFuncionario(Funcionario funcionario) {
        try {
            PreparedStatement ps;
            String sql = "UPDATE Funcionario set status = 'I' WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
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
    public boolean atualizarProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificaLogin(Funcionario funcionario) {
        try {
            PreparedStatement ps;
            ResultSet rs;
            String sql = 
                    "SELECT "
                    + "     * "
                    + " FROM "
                    + "     Funcionario "
                    + " WHERE  "
                    + " login = ? and senha = ? and status = 'A' ";
            ps = connection.prepareCall(sql);
            ps.setString(1,funcionario.getLogin());
            ps.setString(2, funcionario.getSenha());
            
            rs = ps.executeQuery();
            if(rs.next()){
                atualizaFuncionario(rs, funcionario);
                return true;           
            }else {
                return false;
            }
        }catch(SQLException e){
            throw new DaoException("Erro com o banco de dados, Tente novamente");
        }
    }
    
    public void atualizaFuncionario(ResultSet rs, Funcionario funcionario) throws SQLException{
        funcionario.setId(rs.getInt("id"));
        
    }
    
       public Funcionario populateFuncionario(ResultSet rs) throws SQLException{
        Funcionario funcionario = new Funcionario();
        funcionario.setLogin(rs.getString("login"));
        funcionario.setSenha(rs.getString("senha"));
        funcionario.setId(rs.getInt("id"));
        return funcionario;
    }
    
}
