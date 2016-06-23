/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.ReuniaoDAO;
import Exception.BcException;
import Interfaces.IReuniao;
import Model.Reuniao;
import java.util.Date;

/**
 *
 * @author prisley.costa
 */
public class ReuniaoBC implements IReuniao {
    public static ReuniaoBC instance;
   
    public static ReuniaoBC getInstance() { 
        if(instance == null){
            instance = new ReuniaoBC();
        }
        return instance;
    }

    @Override
    public boolean cadastrarReuniao(Reuniao reuniao) {
        if(reuniao == null) {
            throw new BcException("Reuniao nula");
        } else if(reuniao.getAssunto().equals("")) {
            throw new BcException("Assunto nao informado");
        } else if(reuniao.getData() == null) {
            throw new BcException("Data nula");
        //AQUI NÃO TA FUNCIONANDO A DATA
        //}else if (reuniao.getData().before(new Date())) {
            //throw new BcException("Impossivel agendar reuniao em data anterior à atual");
        } else if (reuniao.getMorador().equals("")) {
            throw new BcException("Morador nao informado");
        } else if (reuniao.getPauta().equals("")) {
            throw new BcException("Pauta nao informada");
        } else {
            return ReuniaoDAO.getInstance().cadastrarReuniao(reuniao);
        }
    }
}