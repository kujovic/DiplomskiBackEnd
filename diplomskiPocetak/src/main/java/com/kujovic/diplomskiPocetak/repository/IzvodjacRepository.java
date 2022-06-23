package com.kujovic.diplomskiPocetak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kujovic.diplomskiPocetak.entity.IzvodjacId;
import com.kujovic.diplomskiPocetak.entity.Izvodjac;

public interface IzvodjacRepository extends JpaRepository<Izvodjac, IzvodjacId>{

	@Query(value ="select * from diplomskipocetak2.izvodjac i where i.predmet_id = ?1",nativeQuery = true)
	 List<Izvodjac> findByPredmet(Long predmetId);
	
}
