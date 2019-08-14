package projeto.springboot.service;

import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import projeto.springboot.constante.MensagemEnum;
import projeto.springboot.exception.BusinessException;
import projeto.springboot.model.LinhaExcel;
import projeto.springboot.model.PlanilhaExcel;
import projeto.springboot.repository.PlanilhaRepository;
import projeto.springboot.representation.RequestPlanilhaRepresentation;
import projeto.springboot.representation.ResponsePlanilhaRepresentation;
import projeto.springboot.representation.ResponseRepresentation;
import projeto.springboot.server.Server;

@Service
public class PlanilhaService {
	
	private JmsTemplate jmsTemplate;

    @Autowired
    public PlanilhaService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
	
	@Autowired
	private PlanilhaRepository planilhaRepository;
	
	/**
	 * Consultar planilha 
	 * @return
	 * @throws Exception
	 */
	public ResponsePlanilhaRepresentation consultarPlanilha() throws Exception {
		try {
			ResponsePlanilhaRepresentation response = new ResponsePlanilhaRepresentation();
			List<PlanilhaExcel> listaPlanilha = planilhaRepository.consultarPlanilhaExcel();
			response.setListaPlanilha(listaPlanilha);
			return response;
		} catch (BusinessException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Alterar e remover alguma coluna da planilha
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ResponseRepresentation alterarPlanilha(RequestPlanilhaRepresentation request) throws Exception {
		try {
			this.sendMessage(request);
			return new ResponseRepresentation(MensagemEnum.MENSAGEM_SUCESSO);
		} catch (BusinessException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Enviando para a Fila
	 * @param request
	 * @throws JMSException
	 */
	public void sendMessage(RequestPlanilhaRepresentation request) throws JMSException {
		for(LinhaExcel linha : request.getLinhaExcel()) {
		        jmsTemplate.convertAndSend(Server.PRODUCT_MESSAGE_QUEUE, linha);
		}
    }
}
