/**
 * 
 */
package projeto.springboot.model;

import java.io.Serializable;

/**
 * @author Robson
 *
 */
public class Coluna implements Serializable{

	private static final long serialVersionUID = -4946037284461038220L;
	
	private String coluna;
	private String valor;
	
	public Coluna() {
		// Construtor padrao
	}
	
	public Coluna(String coluna, String valor) {
		this.coluna = coluna;
		this.valor = valor;
	}
	
	public String getColuna() {
		return coluna;
	}
	public void setColuna(String coluna) {
		this.coluna = coluna;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	

}
