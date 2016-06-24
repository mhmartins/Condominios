/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.FuncionarioDAO;
import Exception.BcException;
import Interfaces.IFuncionarioDAO;
import Model.Funcionario;
import Model.Produto;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class FuncionarioBC implements IFuncionarioDAO {

    /*
    *@TODO terminar classe
    
    */
    
    public static FuncionarioBC instance;
    public static FuncionarioBC getInstance(){
        if(instance == null){
            instance = new FuncionarioBC();
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
        if(funcionario.getLogin().trim().isEmpty()){
            throw new BcException("Login inválido");
        }else if(funcionario.getSenha().isEmpty()){
            throw new BcException("Senha inválida");
        }else {
            return FuncionarioDAO.getInstance().verificaLogin(funcionario);
        }
    }
    
}
