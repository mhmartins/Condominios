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
import java.util.List;

/**
 *
 * @author Tobias
 */
public class JdbcFuncionarioDAO implements IFuncionarioDAO {
    
    
    /*
    *@TODO terminar classe
    
    */
    private Connection connection;
    
    public JdbcFuncionarioDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Funcionario> getFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removerFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario verificaLogin(Funcionario funcionario) {
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
                return atualizaFuncionario(rs, funcionario);
            }
            return null;
            
        }catch(SQLException e){
            throw new DaoException("Erro com o banco de dados, Tente novamente");
        }
    }
    
    public Funcionario atualizaFuncionario(ResultSet rs, Funcionario funcionario) throws SQLException{
        funcionario.setId(rs.getInt("id"));
        return funcionario;
    }
    
}
