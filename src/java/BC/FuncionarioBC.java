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
        return FuncionarioDAO.getInstance().getFuncionarios();
    }

    @Override
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        if(funcionario == null){
            throw new BcException("Funcionário inválido");
        }else if(funcionario.getLogin().trim().isEmpty() || funcionario.getLogin() == null){
            throw new BcException("Login inválido");
        }else if(funcionario.getSenha().trim().isEmpty() || funcionario.getSenha() == null) {
            throw new BcException("Senha inválida");
        }else {
            return FuncionarioDAO.getInstance().cadastrarFuncionario(funcionario);
        }
    }

    @Override
    public boolean removerFuncionario(Funcionario funcionario) {
        if(funcionario == null){
            throw new BcException("Funcionário inválido");
        }else if(funcionario.getId() < 0){
            throw new BcException("Funcionario Inválido");
        }else {
            return FuncionarioDAO.getInstance().removerFuncionario(funcionario);
        }
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        return ProdutoBC.getInstance().atualizarProduto(produto);
    }

    @Override
    public boolean verificaLogin(Funcionario funcionario) {
        if(funcionario.getLogin().trim().isEmpty()){
            throw new BcException("Login inválido");
        }else if(funcionario.getSenha().isEmpty()){
            throw new BcException("Senha inválida");
        }else {
            return FuncionarioDAO.getInstance().verificaLogin(funcionario);
        }
    }
    
}
