/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.AcrescimoDAO;
import Exception.BcException;
import Exception.DaoException;
import Interfaces.IAcrescimoDAO;
import Model.Acrescimo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class AcrescimoBC implements IAcrescimoDAO{

    
    public static AcrescimoBC instance;
    public static AcrescimoBC getInstance(){
        if(instance == null){
            instance = new AcrescimoBC();
        }
        return instance;
    }
    
    
    @Override
    public boolean cadastrarAcrescimo(Acrescimo acrescimo) {
       if(acrescimo == null){
           throw new BcException("Acrescimo nulo");
       }else if(acrescimo.getDescricao().trim().isEmpty() || acrescimo.getDescricao() == null){
           throw new BcException("Descrição invalida");
       }else if(acrescimo.getValor() <= 0){
           throw new BcException("Acrescimo nulo");
       }else {
           return AcrescimoDAO.getInstance().cadastrarAcrescimo(acrescimo);
       }
    }

    @Override
    public List<Acrescimo> getAcrescimos() {
       return AcrescimoDAO.getInstance().getAcrescimos();
    }

    @Override
    public boolean removerAcrescimo(Acrescimo acrescimo) {
         if(acrescimo == null){
           throw new BcException("Acrescimo nulo");
       }else if(acrescimo.getDescricao().trim().isEmpty() || acrescimo.getDescricao() == null){
           throw new BcException("Descrição invalida");
       }else if(acrescimo.getValor() <= 0){
           throw new BcException("Acrescimo nulo");
       }else {
           return AcrescimoDAO.getInstance().removerAcrescimo(acrescimo);
       }
    }

    @Override
    public Acrescimo getAcrescimoById(int id) {
        if(id < 0){
            throw new BcException("Acrescimo Inválido");
        }else {
            return AcrescimoDAO.getInstance().getAcrescimoById(id);
        }
    }
    
}
