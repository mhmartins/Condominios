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
            String sql = "SELECT * FROM Produtos";
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                produtos = new ArrayList<Produto>();
                produtos.add(populateProduto(rs));
                return produtos;
            }
            return null;
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
    
}