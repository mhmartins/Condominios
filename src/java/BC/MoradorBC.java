/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.MoradorDAO;
import Exception.BcException;
import Interfaces.IMoradorDAO;
import Model.Morador;
import java.util.List;

/**
 *
 * @author Tuka
 */
public class MoradorBC implements IMoradorDAO {

    public static MoradorBC instance;

    public static MoradorBC getInstance() {
        if(instance == null){
            instance = new MoradorBC();
        }
        return instance;
    }
    
    @Override
    public boolean verificaLogin(Morador morador){
        if(morador.getLogin().equals("") || morador.getSenha().equals("") || morador.getLogin() == null || morador.getSenha() == null){
            throw new BcException("Morador Inválido");
        }
        return MoradorDAO.getInstance().verificaLogin(morador);
    }

    @Override
    public boolean cadastrarMorador(Morador morador) {
        if(morador == null) {
            throw new BcException("Objeto morador nulo");
        } else if(morador.getLogin().equals("")) {
            throw new BcException("Login não informado");
        } else if(morador.getNumApt() == 0) {
            throw new BcException("Numero incorreto para apartamento");
        } else if(morador.getSenha().equals("")) {
            throw new BcException("Senha não informada");
        } else {
            return MoradorDAO.getInstance().cadastrarMorador(morador);
        }
    }

    @Override
    public List<Morador> visualizarMoradores() {
        return MoradorDAO.getInstance().visualizarMoradores();
    }

    @Override
    public Morador getMoradorById(int id) {
        return MoradorDAO.getInstance().getMoradorById(id);
    }

    @Override
    public boolean updateMorador(Morador morador) {
        return MoradorDAO.getInstance().updateMorador(morador);
    }
}