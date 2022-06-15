package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Nastavnik;
import com.kujovic.diplomskiPocetak.repository.NastavnikRepository;


@Service
public class NastavnikService {
	private final NastavnikRepository nastavnikRepository;

	@Autowired
	public NastavnikService(NastavnikRepository nastavnikRepository) {
		this.nastavnikRepository = nastavnikRepository;
	}
	
	
	public Nastavnik dodajNastavnika(Nastavnik nastavnik) {
		return nastavnikRepository.save(nastavnik);
	}
	
	public List<Nastavnik> pronadjiSveNastavnike(){
		return nastavnikRepository.findAll();
	}
	
	public Nastavnik azurirajNastavnika(Nastavnik nastavnik) {
		return nastavnikRepository.save(nastavnik);
	}
	
	public Optional<Nastavnik> nadjiNastavnikaPoId(Long id) {
		return nastavnikRepository.findById(id);
				
	}
	
	public void deleteNastavnik(Long id) {
		nastavnikRepository.deleteById(id);
	}
	
}
