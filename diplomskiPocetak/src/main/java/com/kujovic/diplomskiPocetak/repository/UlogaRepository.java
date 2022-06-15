package com.kujovic.diplomskiPocetak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kujovic.diplomskiPocetak.entity.Uloga;

public interface UlogaRepository extends JpaRepository<Uloga, Long>{
	
}
