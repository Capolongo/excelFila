/**
 * 
 */
package projeto.springboot.representation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.springboot.model.LinhaExcel;

/**
 * @author Robson *
 */
public class RequestPlanilhaRepresentation implements Serializable {
	
	private static final long serialVersionUID = 7475334082075398115L;
	private List<LinhaExcel> linhaExcel = new ArrayList<LinhaExcel>();
	
	public List<LinhaExcel> getLinhaExcel() {
		return linhaExcel;
	}
	public void setLinhaExcel(List<LinhaExcel> linhaExcel) {
		this.linhaExcel = linhaExcel;
	}

}
