/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Acrescimo;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface IAcrescimoDAO {
    
    boolean cadastrarAcrescimo(Acrescimo acrescimo);
    List<Acrescimo> getAcrescimos();
    boolean removerAcrescimo(Acrescimo acrescimo);
    Acrescimo getAcrescimoById(int id);
    
}
