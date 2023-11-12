package org.systemia.servicesoap.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.systemia.servicesoap.contracts.CreateCountryRequest;
import org.systemia.servicesoap.contracts.GetCountriesRequest;
import org.systemia.servicesoap.contracts.GetCountryRequest;
import org.systemia.servicesoap.contracts.GetCountryResponse;
import org.systemia.servicesoap.mappers.CountryToContract;
import org.systemia.servicesoap.mappers.CountryToDomain;
import org.systemia.servicesoap.repository.CountryRepository;

import java.util.Optional;

@Endpoint
@RequiredArgsConstructor
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://my-host/service-soap";
	private final CountryRepository countryRepository;
	private final CountryToContract toContract;
	private final CountryToDomain toDomain;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountriesRequest retrieveCountryByName(
		@RequestPayload GetCountryRequest countryRequest
	) {
		var response = new GetCountriesRequest();
		var getEntities = countryRepository.findByNameContainsIgnoreCase(countryRequest.getName());
		response.getCountries().addAll(getEntities.stream().map(toContract).toList());
		return response;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
	@ResponsePayload
	public GetCountryResponse createCountry(
		@RequestPayload CreateCountryRequest countryRequest
	) {
		GetCountryResponse response = new GetCountryResponse();
		var newCountry = Optional.of(countryRequest).map(toDomain).orElseThrow();
		var countrySaved = countryRepository.save(newCountry);
		response.setCountry(
			Optional.of(countrySaved).map(toContract).orElseThrow()
		);
		return response;
	}
}
