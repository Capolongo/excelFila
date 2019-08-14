package projeto.springboot.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MessageException extends RuntimeException {

	private static final long serialVersionUID = -403870650792271624L;
	
	private static final Logger log = Logger.getLogger(MessageException.class);
	
	public MessageException(Exception e) {
		super(e);
		log.warn(e.getMessage(), e);
	}
	
	public MessageException(String message, Exception e) {
		super(message, e);
		log.warn(message, e);
	}
	
}
