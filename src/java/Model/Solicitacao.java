/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author prisl
 */
public class Solicitacao {
    private int id;
    private List<Mensagem> mensagens;
    private Morador morador;
    private Date dataAbertura;
    private Date dataFinalizado;
    private int status;

    public Solicitacao() {
        this.mensagens = new ArrayList<Mensagem>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(Date dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    
}
