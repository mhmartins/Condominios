/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.ISolicitacao;
import Model.Morador;
import Model.Solicitacao;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public class SolicitacaoDAO implements ISolicitacao {

    public static SolicitacaoDAO instance;

    public static SolicitacaoDAO getInstance() {
        if (instance == null) {
            instance = new SolicitacaoDAO();
        }
        return instance;
    }

    @Override
    public boolean cadastrarSolicitacao(Solicitacao solicitacao) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        ISolicitacao iSolicitacao = iManager.getSolicitacaoDAO();
        return iSolicitacao.cadastrarSolicitacao(solicitacao);
    }

    @Override
    public List<Solicitacao> getSolicitacoes() {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        ISolicitacao iSolicitacao = iManager.getSolicitacaoDAO();
        return iSolicitacao.getSolicitacoes();
    }

    @Override
    public Morador getMoradorById(int id) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        ISolicitacao iSolicitacao = iManager.getSolicitacaoDAO();
        return iSolicitacao.getMoradorById(id);
    }

    @Override
    public boolean responderSolicitacao() {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        ISolicitacao iSolicitacao = iManager.getSolicitacaoDAO();
        return iSolicitacao.responderSolicitacao();
    }

    @Override
    public boolean deleteSolicitacaoById(int id) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        ISolicitacao iSolicitacao = iManager.getSolicitacaoDAO();
        return iSolicitacao.deleteSolicitacaoById(id);
    }
}
