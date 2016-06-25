/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import Interfaces.IAcrescimoDAO;
import Interfaces.IControleFinanceiro;
import Model.Acrescimo;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class ControleFinanceiroBC implements IAcrescimoDAO, IControleFinanceiro {
    
    public static ControleFinanceiroBC instance;
    public static ControleFinanceiroBC getInstance(){
        if(instance == null){
            instance = new ControleFinanceiroBC();
        }
        return instance; 
    }

    @Override
    public boolean cadastrarAcrescimo(Acrescimo acrescimo) {
        return AcrescimoBC.getInstance().cadastrarAcrescimo(acrescimo);
    }

    @Override
    public List<Acrescimo> getAcrescimos() {
        return AcrescimoBC.getInstance().getAcrescimos();
    }

    @Override
    public boolean removerAcrescimo(Acrescimo acrescimo) {
        return AcrescimoBC.getInstance().removerAcrescimo(acrescimo);
    }

    @Override
    public Acrescimo getAcrescimoById(int id) {
        return AcrescimoBC.getInstance().getAcrescimoById(id);
    }

    @Override
    public boolean gerarBoleto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
