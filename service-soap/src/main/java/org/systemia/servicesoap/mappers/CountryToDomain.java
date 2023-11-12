package org.systemia.servicesoap.mappers;

import org.springframework.stereotype.Component;
import org.systemia.servicesoap.contracts.CreateCountryRequest;
import org.systemia.servicesoap.domain.entity.CountryEntity;

import java.util.function.Function;

@Component
public class CountryToDomain implements Function<CreateCountryRequest, CountryEntity> {

	@Override
	public CountryEntity apply(CreateCountryRequest countryRequest) {
		var country = countryRequest.getCountry();
		return CountryEntity.builder()
			.capital(country.getCapital())
			.name(country.getName())
			.population(country.getPopulation())
			.currency(country.getCurrency())
			.build();
	}
}
