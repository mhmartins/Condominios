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
 * @author Tuka
 */
public interface IMoradorDAO {
    
    boolean verificaLogin(Morador morador);
    boolean cadastrarMorador(Morador morador);
    List<Morador> visualizarMoradores();
    Morador getMoradorById(int id);
    boolean updateMorador(Morador morador);
    boolean deleteMoradorById(int id);
}
