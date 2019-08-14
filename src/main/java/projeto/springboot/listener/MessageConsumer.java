package projeto.springboot.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import projeto.springboot.model.LinhaExcel;
import projeto.springboot.repository.PlanilhaRepository;
import projeto.springboot.server.Server;

@Component
public class MessageConsumer {
		
	private static final Logger log = LogManager.getLogger(MessageConsumer.class);
	
		@Autowired
		private PlanilhaRepository planilhaRepository;
	
		
    // Consumindo a fila 
	@JmsListener(destination = Server.PRODUCT_MESSAGE_QUEUE, containerFactory = "jmsFactory")
    public void receiveMessage(LinhaExcel linha) throws Exception {
		log.info("processando mensageria - " + linha);
		planilhaRepository.alterarPlanilha(linha);
		log.info("processado...");
    }
}


