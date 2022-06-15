package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Godina;
import com.kujovic.diplomskiPocetak.repository.GodinaRepository;

@Service
public class GodinaService {

	private final GodinaRepository godinaRepository;

	@Autowired
	public GodinaService(GodinaRepository godinaRepository) {
		this.godinaRepository = godinaRepository;
	}
	
	public Godina dodajGodinu(Godina godina) {
		return godinaRepository.save(godina);
	}
	
	public List<Godina> pronadjiSveGodine(){
		return godinaRepository.findAll();
	}
	
	public Godina azurirajGodinu(Godina godina) {
		return godinaRepository.save(godina);
	}
	
	public Optional<Godina> nadjiGodinuPoId(Long id) {
		return godinaRepository.findById(id);
				
	}
	
	public void deleteGodina(Long id) {
		godinaRepository.deleteById(id);
	}
}
