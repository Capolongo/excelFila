/**
 * 
 */
package projeto.springboot.representation;

import java.io.Serializable;

import projeto.springboot.constante.MensagemEnum;

/**
 * @author resource
 *
 */
public class ResponseRepresentation implements Serializable{
	
	private static final long serialVersionUID = -111442507107752386L;
	
	public ResponseRepresentation() {
		// construtor padrao
	}
	
	public ResponseRepresentation(MensagemEnum mensagem) {
		this.mensagem = mensagem.getMensagem();
		this.codigo = mensagem.getCodigo();
	}
	
	private String mensagem = "";
	
	private int codigo = 0;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
