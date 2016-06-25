/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.MensagemDAO;
import Exception.BcException;
import Interfaces.IMensagemDAO;
import Model.Mensagem;

/**
 *
 * @author prisl
 */
public class MensagemBC implements IMensagemDAO {

    public static MensagemBC instance;

    public static MensagemBC getInstance() {
        if (instance == null) {
            instance = new MensagemBC();
        }
        return instance;
    }

    @Override
    public boolean cadastrarMsg(Mensagem mensagem) {
        if (mensagem == null) {
            throw new BcException("mensagem nula");
        } else if (mensagem.getMorador() == null) {
            throw new BcException("mensagem nula");
        } else if (mensagem.getSolicitacao() == null) {
            throw new BcException("solicitacao nula");
        } else if (mensagem.getTexto().equals("")) {
            throw new BcException("texto em branco");
        } else if (mensagem.getTitulo().equals("")) {
            throw new BcException("titulo em branco");
        } else {
            return MensagemDAO.getInstance().cadastrarMsg(mensagem);
        }
    }

}
