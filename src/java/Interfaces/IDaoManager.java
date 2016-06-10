/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.JdbcMoradorDAO;
import DAO.JdbcProdutoDAO;
import DAO.JdbcReuniaoDAO;
import Exception.DaoException;

/**
 *
 * @author desenvolvimento
 */
public interface IDaoManager {
    void iniciar() throws DaoException;
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    JdbcMoradorDAO getMoradorDAO();
    JdbcProdutoDAO getProdutoDAO();
    JdbcReuniaoDAO getReuniaoDAO();
}