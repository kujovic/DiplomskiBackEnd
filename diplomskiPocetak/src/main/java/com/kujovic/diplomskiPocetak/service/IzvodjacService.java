package com.kujovic.diplomskiPocetak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Izvodjac;
import com.kujovic.diplomskiPocetak.entity.IzvodjacId;
import com.kujovic.diplomskiPocetak.repository.IzvodjacRepository;

@Service
public class IzvodjacService {

	private final IzvodjacRepository izvodjacRepository;

	@Autowired
	public IzvodjacService(IzvodjacRepository izvodjacRepository) {
		this.izvodjacRepository = izvodjacRepository;
	}
	
	public Izvodjac dodajIzvodjaca(Izvodjac izvodjac) {
		return izvodjacRepository.save(izvodjac);
	}
	
	public List<Izvodjac> pronadjiSveIzvodjace(){
		return izvodjacRepository.findAll();
	}
	
	public Izvodjac azurirajIzvodjaca(Izvodjac izvodjac) {
		return izvodjacRepository.save(izvodjac);
	}
	
//	public Uloga nadjiUloguPoId(int id) {
//		return katedraRepository.findKatedraById(id);
//				
//	}
//	
	public void deleteIzvodjac(IzvodjacId izvodjacId) {
		izvodjacRepository.getById(izvodjacId);
	}
	
}
