/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BC;

import DAO.AgendamentoDAO;
import Exception.BcException;
import Interfaces.IAgendamentoDAO;
import Model.Agendamento;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class AgendamentoBC implements IAgendamentoDAO {

       public static AgendamentoBC instance;
    public static AgendamentoBC getInstance(){
        if(instance == null){
            instance = new AgendamentoBC();
        }
        return instance;
    }
    
    @Override
    public boolean realizaAgendamento(Agendamento agendamento) {
        //TODO -- Arrumar isso
        if(agendamento == null){
            throw new BcException("Agendamento nulo");
        }else if (agendamento.getMorador() == null){
            throw new BcException("Morador nulo");
        }else if (agendamento.getArea() == null){
            throw new BcException("Area nula");
        }else {
            return AgendamentoDAO.getInstance().realizaAgendamento(agendamento);
        }
    }

    @Override
    public List<Agendamento> getAgendamentos() {
        return AgendamentoDAO.getInstance().getAgendamentos();
    }
    
}
