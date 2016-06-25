/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.SolicitacaoDAO;
import Exception.BcException;
import Interfaces.ISolicitacao;
import Model.Morador;
import Model.Solicitacao;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public class SolicitacaoBC implements ISolicitacao {

    public static SolicitacaoBC instance;

    public static SolicitacaoBC getInstance() {
        if (instance == null) {
            instance = new SolicitacaoBC();
        }
        return instance;
    }

    @Override
    public boolean cadastrarSolicitacao(Solicitacao solicitacao) {
        if (solicitacao == null) {
            throw new BcException("Objeto Solicitacao nulo");
        } else if (solicitacao.getStatus() != 0) {
            throw new BcException("Status solicitacao esta em branco");
        } else if (solicitacao.getMensagens().isEmpty()) {
            throw new BcException("solicitacao sem mensagens");
        } else if (solicitacao.getDataAbertura() == null) {
            throw new BcException("Nao foi preenchido a data de abertura da solicitacao");
        } else {
            return SolicitacaoDAO.getInstance().cadastrarSolicitacao(solicitacao);
        }
    }

    @Override
    public List<Solicitacao> getSolicitacoes() {
        return SolicitacaoDAO.getInstance().getSolicitacoes();
    }

    @Override
    public Morador getMoradorById(int id) {
        return SolicitacaoDAO.getInstance().getMoradorById(id);
    }

    @Override
    public boolean responderSolicitacao() {
        return SolicitacaoDAO.getInstance().responderSolicitacao();
    }

    @Override
    public boolean deleteSolicitacaoById(int id) {
        return SolicitacaoDAO.getInstance().deleteSolicitacaoById(id);
    }
    
    
}
