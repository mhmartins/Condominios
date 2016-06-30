/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BC.ControleFinanceiroBC;
import Interfaces.IAcrescimoDAO;
import Interfaces.IControleFinanceiro;
import java.util.List;

/**
 *
 * @author desenvolvimento
 */
public class ControleFinanceiro implements IAcrescimoDAO, IControleFinanceiro{

    @Override
    public boolean cadastrarAcrescimo(Acrescimo acrescimo) {
        return ControleFinanceiroBC.getInstance().cadastrarAcrescimo(acrescimo);
    }

    @Override
    public List<Acrescimo> getAcrescimos() {
        return ControleFinanceiroBC.getInstance().getAcrescimos();
    }

    @Override
    public boolean removerAcrescimo(Acrescimo acrescimo) {
        return ControleFinanceiroBC.getInstance().removerAcrescimo(acrescimo);
    }

    @Override
    public Acrescimo getAcrescimoById(int id) {
        return ControleFinanceiroBC.getInstance().getAcrescimoById(id);
    }

    @Override
    public boolean gerarBoleto(List<Morador> moradores) {
        return ControleFinanceiroBC.getInstance().gerarBoleto(moradores);
    }
    
}
