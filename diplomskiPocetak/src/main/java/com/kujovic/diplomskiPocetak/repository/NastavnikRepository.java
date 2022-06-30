package com.kujovic.diplomskiPocetak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kujovic.diplomskiPocetak.entity.Nastavnik;

public interface NastavnikRepository extends JpaRepository<Nastavnik, Long>{
	
	
	@Query(value ="SELECT  n.nastavnik_id, n.ime_prezime, n.status, n.broj_telefona, n.katedra_katedra_id FROM  diplomskipocetak2.katedra k, diplomskipocetak2.nastavnik n where  n.katedra_katedra_id=k.katedra_id and k.katedra_id = ?1",nativeQuery = true)
	 
	
	List<Nastavnik> findNastavniciNaKatedri(Long id);


	@Query(value = "select max(diplomskipocetak2.nastavnik.nastavnik_id+1) from diplomskipocetak2.nastavnik;", nativeQuery = true)
	Long vratiMaxNastavnikId();
	

}

