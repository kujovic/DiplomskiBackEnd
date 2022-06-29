package com.kujovic.diplomskiPocetak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kujovic.diplomskiPocetak.entity.Izvodjac;

public interface IzvodjacRepository extends JpaRepository<Izvodjac, Long> {

	@Query(value = "select * from diplomskipocetak2.izvodjac i where i.predmet_id = ?1", nativeQuery = true)
	List<Izvodjac> findByPredmet(Long predmetId);

	
	@Query(value = "select max(diplomskipocetak2.izvodjac.izvodjac_id+1) from diplomskipocetak2.izvodjac;", nativeQuery = true)
	Long vratiMaxIzvodjacId();
	
//	@Modifying
//	@Query(value ="INSERT INTO `diplomskipocetak2`.`izvodjac` (`predmet_id`, `uloga_id`, `nastavnik_id`, `godina_id`, `studijski_program_id`, `pozicija`, `semestar`) "
//			+ "VALUES ('?1', '?2', '?3', '?4', '?5', '?6', '?7')",nativeQuery = true)
//	@Transactional
//	void addIzvodjacMethod 
//	(Long predmetId, Long ulogaId,Long nastavnikId, Long godinaId, Long studijskiProgramId, int pozicija, int semestar);
}
