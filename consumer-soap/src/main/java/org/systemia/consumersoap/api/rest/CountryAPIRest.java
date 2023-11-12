package org.systemia.consumersoap.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.systemia.consumersoap.contracts.CreateCountryRequest;
import org.systemia.consumersoap.contracts.GetCountriesRequest;
import org.systemia.consumersoap.contracts.GetCountryRequest;
import org.systemia.consumersoap.contracts.GetCountryResponse;
import org.systemia.consumersoap.proxy.SoapClient;

@RestController
@RequestMapping("api/countries")
public class CountryAPIRest {

	@Autowired
	private SoapClient soapClient;

	@PostMapping
	public GetCountryResponse getCountryResponse(
		@RequestBody CreateCountryRequest countryRequest
	) {
		return soapClient.createCountry(countryRequest);
	}

	@GetMapping
	public GetCountriesRequest listCountryByFilterName(
		@RequestParam String name
	) {
		GetCountryRequest getCountryRequest = new GetCountryRequest();
		getCountryRequest.setName(name);
		return soapClient.listCountries(getCountryRequest);
	}
}
