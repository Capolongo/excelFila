/**
 * 
 */
package projeto.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Robson *
 */
public class LinhaExcel implements Serializable {

	private static final long serialVersionUID = -4946037284461038220L;
	
	private Integer linha = null;

	private List<Coluna> coluna = new ArrayList<Coluna>();
	
	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public List<Coluna> getColuna() {
		return coluna;
	}

	public void setColuna(List<Coluna> coluna) {
		this.coluna = coluna;
	}
}
