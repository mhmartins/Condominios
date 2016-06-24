/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.IInformacaoDAO;
import Model.Informacao;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class InformacaoDAO implements IInformacaoDAO{

    public static InformacaoDAO instance;
    public static InformacaoDAO getInstance(){
        if(instance == null){
            instance = new InformacaoDAO();
        }
        return instance;
    }
    
    
    @Override
    public List<Informacao> getInformacoesAtivas() {
        IDaoManager iManager = new JdbcDaoManager();
        iManager.iniciar();
        IInformacaoDAO informacaoDAO = iManager.getInformacaoDAO();
        return informacaoDAO.getInformacoesAtivas();
    }

    @Override
    public boolean cadastraInformacao(Informacao informacao) {
        IDaoManager iManager = new JdbcDaoManager();
        iManager.iniciar();
        IInformacaoDAO informacaoDAO = iManager.getInformacaoDAO();
        return informacaoDAO.cadastraInformacao(informacao);
    }
    
}
