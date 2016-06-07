/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Morador;

/**
 *
 * @author Tuka
 */
public interface IMoradorDAO {
    
    boolean verificaLogin(Morador morador);
    
}
