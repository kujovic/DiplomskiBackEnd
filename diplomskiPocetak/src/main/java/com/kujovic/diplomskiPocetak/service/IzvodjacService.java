package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Izvodjac;
import com.kujovic.diplomskiPocetak.entity.IzvodjacId;
import com.kujovic.diplomskiPocetak.entity.Katedra;
import com.kujovic.diplomskiPocetak.entity.Predmet;
import com.kujovic.diplomskiPocetak.repository.IzvodjacRepository;
import com.kujovic.diplomskiPocetak.repository.PredmetRepository;

@Service
public class IzvodjacService {

	private final IzvodjacRepository izvodjacRepository;
	private final PredmetRepository predmetRepository;

	@Autowired
	public IzvodjacService(IzvodjacRepository izvodjacRepository,PredmetRepository predmetRepository) {
		this.izvodjacRepository = izvodjacRepository;
		this.predmetRepository = predmetRepository;
	}
	
	public Izvodjac dodajIzvodjaca(Izvodjac izvodjac) {
		return izvodjacRepository.save(izvodjac);
	}
	
	public List<Izvodjac> pronadjiSveIzvodjace(){
		return izvodjacRepository.findAll();
	}
	
	public List<Izvodjac> pronadjiSveIzvodjacePoPredmetu(Long id){
		return izvodjacRepository.findByPredmet(id);
	}
	
	public Izvodjac azurirajIzvodjaca(Izvodjac izvodjac) {
		return izvodjacRepository.save(izvodjac);
	}
	
	public Optional<Predmet> nadjiPredmetPoId(Long id) {
		return predmetRepository.findById(id);
				
	}

	public void deleteIzvodjac(IzvodjacId izvodjacId) {
		izvodjacRepository.getById(izvodjacId);
	}
	
}
