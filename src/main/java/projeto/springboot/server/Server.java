package projeto.springboot.server;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages="projeto.springboot")
@EnableSwagger2
@EnableJms
public class Server {
	
	public final static String PRODUCT_MESSAGE_QUEUE = "product-message-queue";
	
	public static void main(String[] args) {
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");
		SpringApplication.run(Server.class, args);
	}
	
	@Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
      DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }

}
