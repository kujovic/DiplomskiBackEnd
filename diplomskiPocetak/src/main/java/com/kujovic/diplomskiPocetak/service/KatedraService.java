package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Katedra;
import com.kujovic.diplomskiPocetak.repository.KatedraRepository;

@Service
public class KatedraService {
	
	private final KatedraRepository katedraRepository;

	@Autowired
	public KatedraService(KatedraRepository katedraRepository) {
		this.katedraRepository = katedraRepository;
	}
	
	public Katedra dodajKatedru(Katedra katedra) {
		return katedraRepository.save(katedra);
	}
	
	public List<Katedra> pronadjiSveKatedre(){
		return katedraRepository.findAll();
	}
	
	public Katedra azurirajKatedru(Katedra katedra) {
		return katedraRepository.save(katedra);
	}
	
	public Optional<Katedra> nadjiKatedruPoId(Long id) {
		return katedraRepository.findById(id);
				
	}
	
	public void deleteKatedra(Long id) {
		katedraRepository.deleteById(id);
	}
	
}
