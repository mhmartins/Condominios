/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IAgendamentoDAO;
import Interfaces.IAreaDAO;
import Interfaces.IDaoManager;
import Model.Agendamento;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class AgendamentoDAO implements IAgendamentoDAO{

    public static AgendamentoDAO instance;
    public static AgendamentoDAO getInstance(){
        if(instance == null){
            instance = new AgendamentoDAO();
        }
        return instance;
    }
    
    private AgendamentoDAO(){
        
    }
    
    @Override
    public boolean realizaAgendamento(Agendamento agendamento) {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IAgendamentoDAO agendamentoDAO = iManager.getAgendamentoDAO();
        return agendamentoDAO.realizaAgendamento(agendamento);
    }

    @Override
    public List<Agendamento> getAgendamentos() {
        IDaoManager iManager;
        iManager = new JdbcDaoManager();
        iManager.iniciar();
        IAgendamentoDAO agendamentoDAO = iManager.getAgendamentoDAO();
        return agendamentoDAO.getAgendamentos();
    }
    
}
