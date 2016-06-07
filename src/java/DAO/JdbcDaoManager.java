/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DaoException;
import Interfaces.IDaoManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tuka
 */
public class JdbcDaoManager implements IDaoManager{

    
    public static JdbcDaoManager instance;
    public static JdbcDaoManager getInstance() {
        if(instance == null){
            instance = new JdbcDaoManager();
           
        }
         return instance;
    }
   
   
    private Connection connection;
    private JdbcMoradorDAO moradorDAO;
    
    public JdbcDaoManager(){
        
    }
    
    @Override
    public void iniciar() throws DaoException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                String url;
                url = "jdbc:mysql://localhost:3306/Condominio";
                connection = DriverManager.getConnection(url, "root", "root");
                connection.setAutoCommit(false);
        }catch (ClassNotFoundException e) {
            throw new DaoException("Erro com o conector do JDBC driver");
        }catch(SQLException e) {
            throw new DaoException("Ocorreu um erro com o banco de dados, tente novamente " + e.getMessage());
        }
        moradorDAO = new JdbcMoradorDAO(connection);
          
        
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!connection.isClosed())
                connection.close();
        } catch (SQLException ex) {
            throw new DaoException("Erro "+ex.getMessage());
        }
    }

    @Override
    public void confirmarTransação() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao tentar confirmar transação" + ex.getMessage());
        }
    }

    @Override
    public void abortarTransação() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new DaoException("Ocorreu um erro ao tentar abortar transação" + ex.getMessage());
        }
    }    

    @Override
    public JdbcMoradorDAO getMoradorDAO() {
        if(moradorDAO == null){
            iniciar();
        }
        return moradorDAO;
    }

}
