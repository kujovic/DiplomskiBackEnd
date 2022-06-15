package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Uloga;
import com.kujovic.diplomskiPocetak.repository.UlogaRepository;

@Service
public class UlogaService {

	private final UlogaRepository ulogaRepository;

	@Autowired
	public UlogaService(UlogaRepository ulogaRepository) {
		this.ulogaRepository = ulogaRepository;
	}
	
	public Uloga dodajUlogu(Uloga uloga) {
		return ulogaRepository.save(uloga);
	}
	
	public List<Uloga> pronadjiSveUloge(){
		return ulogaRepository.findAll();
	}
	
	public Uloga azurirajUlogu(Uloga uloga) {
		return ulogaRepository.save(uloga);
	}
	
	public Optional<Uloga> nadjiUloguPoId(Long id) {
		return ulogaRepository.findById(id);
	}
	
	public void deleteUloga(Long id) {
		ulogaRepository.deleteById(id);
	}
	
}
