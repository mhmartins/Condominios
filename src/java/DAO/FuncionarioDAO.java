/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.IFuncionarioDAO;
import Model.Funcionario;
import Model.Produto;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class FuncionarioDAO implements IFuncionarioDAO{

    
    /*
    *@TODO terminar classe
    
    */
    public static FuncionarioDAO instance;
    public static FuncionarioDAO getInstance(){
        if(instance == null){
            instance = new FuncionarioDAO();
        }
        return instance;
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
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IFuncionarioDAO funcionarioDAO = iManager.getFuncionarioDAO();
        return funcionarioDAO.verificaLogin(funcionario);
    }
    
}
