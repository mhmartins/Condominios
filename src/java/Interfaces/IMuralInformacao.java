/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Informacao;
import Model.MuralInformacoes;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public interface IMuralInformacao {
    
    MuralInformacoes getMuralInformacao();
    boolean cadastraInformacao(Informacao informacao);
    
}
