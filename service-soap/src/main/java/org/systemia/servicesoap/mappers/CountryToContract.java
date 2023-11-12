package org.systemia.servicesoap.mappers;

import org.springframework.stereotype.Component;
import org.systemia.servicesoap.contracts.Country;
import org.systemia.servicesoap.domain.entity.CountryEntity;

import java.util.function.Function;

@Component
public class CountryToContract implements Function<CountryEntity, Country> {
	@Override
	public Country apply(CountryEntity countryEntity) {
		Country country = new Country();
		country.setCapital(countryEntity.getCapital());
		country.setName(countryEntity.getName());
		country.setPopulation(countryEntity.getPopulation());
		country.setCurrency(countryEntity.getCurrency());
		return country;
	}
}
