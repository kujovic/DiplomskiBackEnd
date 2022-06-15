package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Predmet;
import com.kujovic.diplomskiPocetak.repository.PredmetRepository;

@Service
public class PredmetService {

	private final PredmetRepository predmetRepository;

	@Autowired
	public PredmetService(PredmetRepository predmetRepository) {
		this.predmetRepository = predmetRepository;
	}
	
	public Predmet dodajPredmet(Predmet predmet) {
		return predmetRepository.save(predmet);
	}
	
	public List<Predmet> pronadjiSvePredmete(){
		return predmetRepository.findAll();
	}
	
	public Predmet azurirajPredmet(Predmet predmet) {
		return predmetRepository.save(predmet);
	}
	
	public Optional<Predmet> nadjiPredmetPoId(Long id) {
		return predmetRepository.findById(id);
				
	}
	
	public void deletePredmet(Long id) {
		predmetRepository.deleteById(id);
	}
	
}
