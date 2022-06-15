package com.kujovic.diplomskiPocetak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kujovic.diplomskiPocetak.entity.IzvodjacId;
import com.kujovic.diplomskiPocetak.entity.Izvodjac;

public interface IzvodjacRepository extends JpaRepository<Izvodjac, IzvodjacId>{

}
