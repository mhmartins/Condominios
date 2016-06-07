/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enum;

/**
 *
 * @author Tuka
 */
public enum TipoMorador {
    
    SINDICO('S',"Sindico"),CONDOMINO('C',"Condômino");
    
    private char tipo;
    private String nome;
    
    private TipoMorador(char tipo, String nome){
        this.tipo = tipo;
        this.nome = nome;
    }
    public static TipoMorador getBy(char tipo){
        for(TipoMorador tipoEnum : TipoMorador.values()){
            if(tipoEnum.getTipo() == tipo){
                return tipoEnum;
            }
        }
        return null;
    }
        public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
}
