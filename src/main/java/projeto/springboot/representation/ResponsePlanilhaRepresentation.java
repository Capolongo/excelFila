/**
 * 
 */
package projeto.springboot.representation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto.springboot.model.PlanilhaExcel;

/**
 * @author Robson *
 */
public class ResponsePlanilhaRepresentation implements Serializable {

	private static final long serialVersionUID = -4946037284461038220L;
	
	private List<PlanilhaExcel> listaPlanilha = new ArrayList<PlanilhaExcel>();

	public List<PlanilhaExcel> getListaPlanilha() {
		return listaPlanilha;
	}

	public void setListaPlanilha(List<PlanilhaExcel> listaPlanilha) {
		this.listaPlanilha = listaPlanilha;
	}

	
	}
