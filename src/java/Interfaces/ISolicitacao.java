/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Morador;
import Model.Solicitacao;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public interface ISolicitacao {
    boolean cadastrarSolicitacao(Solicitacao solicitacao);
    List<Solicitacao> getSolicitacoes();
    Morador getMoradorById(int id);
    boolean deleteSolicitacaoById(int id);
    boolean responderSolicitacao();
}
