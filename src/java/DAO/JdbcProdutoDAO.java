/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IProdutoDAO;
import Model.Produto;
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
 * @author desenvolvimento
 */
public class JdbcProdutoDAO implements IProdutoDAO{

    
    private Connection connection;
    
    public JdbcProdutoDAO(Connection connection){
        this.connection = connection;
    }
    
    
    @Override
    public List<Produto> getProdutos() {
        try {
            List<Produto> produtos;
            String sql = "SELECT * FROM Produto";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            produtos = new ArrayList<Produto>();
            while(rs.next()){    
                produtos.add(populateProduto(rs));
            }
            return produtos;
            
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente "+ex.getMessage());
        }
    
    }
    
    
    public Produto populateProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setNome(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setQuantidade(rs.getInt("quantidade"));
        return produto;
    }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        try {
            PreparedStatement ps;        
            String sql = "INSERT INTO Produto (nome,descricao,quantidade) VALUES (?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQuantidade());
           
            if(ps.executeUpdate() == 1){
                return true;
            }else {
                return false;
            }    
        } catch (SQLException ex) {
            throw new DaoException("Erro com o banco de dados, tente novamente "+ex.getMessage());
        }
    
    
    }
    
}
