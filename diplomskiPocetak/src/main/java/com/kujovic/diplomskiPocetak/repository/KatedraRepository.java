package com.kujovic.diplomskiPocetak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kujovic.diplomskiPocetak.entity.Katedra;

public interface KatedraRepository extends JpaRepository<Katedra, Long>{


	
}
