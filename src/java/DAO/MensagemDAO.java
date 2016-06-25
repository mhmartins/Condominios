/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoManager;
import Interfaces.IMensagemDAO;
import Interfaces.IMoradorDAO;
import Model.Mensagem;

/**
 *
 * @author prisl
 */
public class MensagemDAO implements IMensagemDAO {

    public static MensagemDAO instance;

    public static MensagemDAO getInstance() {
        if (instance == null) {
            instance = new MensagemDAO();
        }
        return instance;
    }

    @Override
    public boolean cadastrarMsg(Mensagem mensagem) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IMensagemDAO mensagemDAO = iManager.getMensagemDAO();
        return mensagemDAO.cadastrarMsg(mensagem);
    }

}
