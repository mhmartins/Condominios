/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Agendamento;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface IAgendamentoDAO {
    
    boolean realizaAgendamento(Agendamento agendamento);
    List<Agendamento> getAgendamentos();
}
