/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.InformacaoDAO;
import Exception.BcException;
import Interfaces.IInformacaoDAO;
import Model.Informacao;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class InformacaoBC implements IInformacaoDAO{

    public static InformacaoBC instance;
    public static InformacaoBC getInstance(){
        if(instance == null){
            instance = new InformacaoBC();
        }
        return instance;
    }
    
    
    @Override
    public List<Informacao> getInformacoesAtivas() {
        return InformacaoDAO.getInstance().getInformacoesAtivas();
    }

    @Override
    public boolean cadastraInformacao(Informacao informacao) {
        if(informacao.getInformacao() == null || informacao.getInformacao().trim().isEmpty()){
            throw new BcException("Informação inválida");
        }else if(informacao.getTitulo() == null || informacao.getTitulo().trim().isEmpty()){
            throw new BcException("Informação inválida");
        }else if(informacao.getMorador() == null || informacao.getMorador().getId() < 0){
            throw new BcException("Morador inválido");
        }else {
            return InformacaoDAO.getInstance().cadastraInformacao(informacao);
        }
    }
    
}
