/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Mensagem;

/**
 *
 * @author prisl
 */
public interface IMensagemDAO {
    boolean cadastrarMsg(Mensagem mensagem);
}
