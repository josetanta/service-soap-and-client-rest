package org.systemia.servicesoap.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.systemia.servicesoap.contracts.Currency;
import org.systemia.servicesoap.domain.entity.CountryEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("test-jpa")
public class CountryRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;

	@Test
	void testCreateACountry() {
		var country = CountryEntity.builder()
			.capital("Capital")
			.currency(Currency.EUR)
			.name("Country")
			.population(1200)
			.build();
		var countrySaved = countryRepository.save(country);

		assertThat(countrySaved).isNotNull();
		assertEquals(1, countryRepository.count());
	}

	@Test
	void whenCreateTwoCountries_thenAssertionsAnError() {
		var country1 = CountryEntity.builder()
			.capital("Capital")
			.currency(Currency.EUR)
			.name("Country")
			.population(1200)
			.build();

		var country2 = CountryEntity.builder()
			.capital("Capital")
			.currency(Currency.EUR)
			.name("Country")
			.population(1200)
			.build();

		assertThrows(Exception.class, () -> {
			countryRepository.saveAll(
				List.of(country1, country2)
			);
		});
	}
}
