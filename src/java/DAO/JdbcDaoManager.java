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
    private JdbcProdutoDAO produtoDAO;
    private JdbcReuniaoDAO reuniaoDAO;
    private JdbcAreaDAO areaDAO;
    private JdbcAgendamentoDAO agendamentoDAO;
    private JdbcInformacaoDAO informacaoDAO;
    private JdbcFuncionarioDAO funcionarioDAO;
    private JdbcSolicitacaoDAO solicitacaoDAO;
    private JdbcAcrescimoDAO acrescimoDAO;
    private JdbcMensagemDAO mensagemDAO;
    private JdbcControleFinanceiroDAO controleDAO;
    
    
    public JdbcDaoManager(){
        
    }
    
    @Override
    public void iniciar() throws DaoException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                String url;
                url = "jdbc:mysql://acesolutions.com.br:3306/aceso538_condominos";
                connection = DriverManager.getConnection(url, "aceso538_cond", "batata");
                connection.setAutoCommit(false);
        }catch (ClassNotFoundException e) {
            throw new DaoException("Erro com o conector do JDBC driver");
        }catch(SQLException e) {
            throw new DaoException("Ocorreu um erro com o banco de dados, tente novamente " + e.getMessage());
        }
        moradorDAO = new JdbcMoradorDAO(connection);
        produtoDAO = new JdbcProdutoDAO(connection);
        reuniaoDAO = new JdbcReuniaoDAO(connection);
        agendamentoDAO = new JdbcAgendamentoDAO(connection);
        areaDAO = new JdbcAreaDAO(connection);
        informacaoDAO = new JdbcInformacaoDAO(connection);
        funcionarioDAO = new JdbcFuncionarioDAO(connection);
        acrescimoDAO = new JdbcAcrescimoDAO(connection);
        solicitacaoDAO = new JdbcSolicitacaoDAO(connection);
        mensagemDAO = new JdbcMensagemDAO(connection);
        controleDAO = new JdbcControleFinanceiroDAO(connection);
        
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

    @Override
    public JdbcProdutoDAO getProdutoDAO() {
        if(produtoDAO == null){
            iniciar();
        }
        return produtoDAO;
    }

    @Override
    public JdbcReuniaoDAO getReuniaoDAO() {
        if(reuniaoDAO == null) {
            iniciar();
        }
        return reuniaoDAO;
    }

    @Override
    public JdbcAgendamentoDAO getAgendamentoDAO() {
        if(agendamentoDAO == null) {
            iniciar();
        }
        return agendamentoDAO;
    }

    @Override
    public JdbcAreaDAO getAreaDAO() {
        if(areaDAO == null) {
            iniciar();
        }
        return areaDAO;
    }

    @Override
    public JdbcInformacaoDAO getInformacaoDAO() {
        if(informacaoDAO == null){
            iniciar();
        }
        return informacaoDAO;
    }

    @Override
    public JdbcFuncionarioDAO getFuncionarioDAO() {
        if(funcionarioDAO == null){
            iniciar();
        }
        return funcionarioDAO;
    }

    @Override
    public JdbcSolicitacaoDAO getSolicitacaoDAO() {
        if(solicitacaoDAO == null){
            iniciar();
        }
        return solicitacaoDAO;
    }

    @Override
    public JdbcAcrescimoDAO getAcrescimoDAO() {
        if(acrescimoDAO == null){
            iniciar();
        }
        return acrescimoDAO;
    }

    @Override
    public JdbcMensagemDAO getMensagemDAO() {
        if(mensagemDAO == null){
            iniciar();
        }
        return mensagemDAO;
    }

    @Override
    public JdbcControleFinanceiroDAO getControleFinanceiroDAO() {
        if(controleDAO == null){
            iniciar();
        }
        return controleDAO;
    }

}
