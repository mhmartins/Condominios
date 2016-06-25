/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BC.AcrescimoBC;
import Exception.DaoException;
import Interfaces.IControleFinanceiro;
import Model.Acrescimo;
import Model.Morador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class JdbcControleFinanceiroDAO implements IControleFinanceiro {

    private Connection connection;
    
    public JdbcControleFinanceiroDAO(Connection connection){
        this.connection = connection;
    }
    


    @Override
    public boolean gerarBoleto(List<Morador> moradores) {
        double parcela = calculaParcela();
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        try {
            for(Morador morador : moradores){
                PreparedStatement ps;
                String sql = "INSERT INTO Boletos (valor,id_morador,mes,ano,status) VALUES (?,?,?,?,'P')";

                ps = connection.prepareStatement(sql);
                ps.setDouble(1, parcela);
                ps.setInt(2,morador.getId());
                ps.setInt(3,month);
                ps.setInt(4,year);
                ps.executeUpdate();
            }
            
            return true;
        }catch(SQLException e){
            throw new DaoException("Erro com o banco de dados, tente novamente");
        }
    }
    
    
    public double calculaParcela(){
          //Valor fixo do boleto 
        double fixo = 500;
        double parcela = fixo;
        
        List<Acrescimo> acrescimos = AcrescimoBC.getInstance().getAcrescimos();
        for(Acrescimo a : acrescimos){
            parcela += a.getValor();
        }
        return parcela;
    }
    
}
