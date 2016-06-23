/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Reuniao;
import java.util.List;

/**
 *
 * @author prisley.costa
 */
public interface IReuniao {
    boolean cadastrarReuniao(Reuniao reuniao);
    List<Reuniao> visualizarReuniao();
}
