package org.systemia.consumersoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.systemia.consumersoap.proxy.SoapClient;

@Configuration
public class SoapConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("org.systemia.consumersoap.contracts");
		return marshaller;
	}

	@Bean
	public SoapClient soapClient(Jaxb2Marshaller marshaller) {
		SoapClient soapClient = new SoapClient();
		soapClient.setDefaultUri("http://localhost:8082/ws");
		soapClient.setMarshaller(marshaller);
		soapClient.setUnmarshaller(marshaller);
		return soapClient;
	}

}
