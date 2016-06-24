/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import Interfaces.IMuralInformacao;
import Model.Informacao;
import Model.MuralInformacoes;

/**
 *
 * @author Tobias
 */
public class MuralInformacaoBC implements IMuralInformacao {

    public static MuralInformacaoBC instance;
    public static MuralInformacaoBC getInstance(){
        if(instance == null){
            instance = new MuralInformacaoBC();
        }
        return instance;
    }
    
    @Override
    public MuralInformacoes getMuralInformacao() {
        MuralInformacoes mural = new MuralInformacoes();
        mural.setInformacoes(InformacaoBC.getInstance().getInformacoesAtivas());
        return mural;
    }

    @Override
    public boolean cadastraInformacao(Informacao informacao) {
        return InformacaoBC.getInstance().cadastraInformacao(informacao);
    }
    
}
