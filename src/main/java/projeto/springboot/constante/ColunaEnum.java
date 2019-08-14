package projeto.springboot.constante;

/**
 * Enum que representa as colunas da planilha, até o E
 * @author resource
 *
 */
public enum ColunaEnum {
	A(1,"A"),
	B(2,"B"),
	C(3,"C"),
	D(4,"D"),
	E(5,"E");
	
	private String mensagem;
	private int codigo;
	
	ColunaEnum(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	public static Integer getColuna(String mensagem) {
		for(ColunaEnum coluna : ColunaEnum.values()) {
			if(mensagem.equalsIgnoreCase(coluna.getMensagem())) {
				return coluna.getCodigo();
			}
		}
		return null;
	}
	
	public static String getCodigo(int codigo) {
		for(ColunaEnum coluna : ColunaEnum.values()) {
			if(coluna.getCodigo() == codigo) {
				return coluna.getMensagem();
			}
		}
		return null;
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
