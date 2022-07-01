package com.kujovic.diplomskiPocetak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kujovic.diplomskiPocetak.entity.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long>{

	@Query(value = "select max(diplomskipocetak2.predmet.predmet_id+1) from diplomskipocetak2.predmet;", nativeQuery = true)
	Long vratiMaxPredmetId();
	
	
	
	
	
}
