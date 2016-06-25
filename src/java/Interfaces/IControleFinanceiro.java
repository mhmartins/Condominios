/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Morador;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface IControleFinanceiro {
    
    boolean gerarBoleto(List<Morador> moradores);
    
    
}
