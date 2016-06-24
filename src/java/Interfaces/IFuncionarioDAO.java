/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Funcionario;
import Model.Produto;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface IFuncionarioDAO {
    
    List<Funcionario> getFuncionarios();
    boolean cadastrarFuncionario(Funcionario funcionario);
    boolean removerFuncionario(Funcionario funcionario);
    boolean atualizarProduto(Produto produto);
    Funcionario verificaLogin(Funcionario funcionario);
    
}
