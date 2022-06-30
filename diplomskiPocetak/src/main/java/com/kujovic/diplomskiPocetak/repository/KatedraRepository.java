package com.kujovic.diplomskiPocetak.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kujovic.diplomskiPocetak.entity.Katedra;

public interface KatedraRepository extends JpaRepository<Katedra, Long>{


	@Query(value = "select max(diplomskipocetak2.katedra.katedra_id+1) from diplomskipocetak2.katedra;", nativeQuery = true)
	Long vratiMaxKatedraId();
	
}
