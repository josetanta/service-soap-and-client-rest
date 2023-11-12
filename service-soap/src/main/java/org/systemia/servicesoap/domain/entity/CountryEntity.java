package org.systemia.servicesoap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.systemia.servicesoap.contracts.Currency;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String name;

	private int population;

	@Column(unique = true, nullable = false)
	private String capital;

	@Enumerated(EnumType.STRING)
	private Currency currency;
}
