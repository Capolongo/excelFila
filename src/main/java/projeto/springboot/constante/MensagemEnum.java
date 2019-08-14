package projeto.springboot.constante;

public enum MensagemEnum {
	MENSAGEM_SUCESSO(200, "Sucesso"),
	MENSAGEM_ERROR(400, "Sistema Indisponivel");
	
	private String mensagem;
	private int codigo;
	
	MensagemEnum(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
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
