/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.InformacaoDAO;
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
    public boolean cadastraInformacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
