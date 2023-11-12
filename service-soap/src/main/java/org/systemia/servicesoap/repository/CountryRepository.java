package org.systemia.servicesoap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.systemia.servicesoap.domain.entity.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
	Optional<CountryEntity> findByNameLikeIgnoreCase(String name);
	List<CountryEntity> findByNameContainsIgnoreCase(String name);
}
