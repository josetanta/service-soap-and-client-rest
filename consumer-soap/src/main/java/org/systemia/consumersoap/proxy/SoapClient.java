package org.systemia.consumersoap.proxy;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.systemia.consumersoap.contracts.CreateCountryRequest;
import org.systemia.consumersoap.contracts.GetCountriesRequest;
import org.systemia.consumersoap.contracts.GetCountryRequest;
import org.systemia.consumersoap.contracts.GetCountryResponse;

public class SoapClient extends WebServiceGatewaySupport {
	private final SoapActionCallback soapActionCallback = new SoapActionCallback("http://my-host/service-soap");

	public GetCountryResponse createCountry(
		CreateCountryRequest createCountryRequest
	) {
		return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
			"http://localhost:8082/ws",
			createCountryRequest,
			soapActionCallback
		);
	}

	public GetCountriesRequest listCountries(
		GetCountryRequest countryRequest
	) {
		return (GetCountriesRequest) getWebServiceTemplate().marshalSendAndReceive(
			"http://localhost:8082/ws",
			countryRequest,
			soapActionCallback
		);
	}
}
