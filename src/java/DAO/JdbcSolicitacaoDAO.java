/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.ISolicitacao;
import Model.Morador;
import Model.Solicitacao;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public class JdbcSolicitacaoDAO implements ISolicitacao {

    private Connection connection;

    public JdbcSolicitacaoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean cadastrarSolicitacao(Solicitacao solicitacao) {
        //sql
    }

    @Override
    public List<Solicitacao> getSolicitacoes() {
        //sql
    }

    @Override
    public Morador getMoradorById(int id) {
        //sql
    }

    @Override
    public boolean responderSolicitacao() {
        //sql
    }

    @Override
    public boolean deleteSolicitacaoById(int id) {
        //sql
    }
}
