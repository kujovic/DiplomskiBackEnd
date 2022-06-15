package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kujovic.diplomskiPocetak.entity.Nastavnik;
import com.kujovic.diplomskiPocetak.service.NastavnikService;

@RestController
@RequestMapping("/nastavnik")
public class NastavnikController {

private final NastavnikService nastavnikService;
	
	public NastavnikController(NastavnikService nastavnikService) {
		this.nastavnikService=nastavnikService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Nastavnik>> getAllNastavnike(){
		List<Nastavnik> nastavnici = nastavnikService.pronadjiSveNastavnike();
		return new ResponseEntity<>(nastavnici,HttpStatus.OK);
	}
	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Nastavnik> getNastavnikById (@PathVariable("id") Long id){
//		Nastavnik nastavnik = nastavnikService.nadjiNastavnikaPoId(id);
//		return new ResponseEntity<>(nastavnik,HttpStatus.OK);
//		
//	}
	
	@PostMapping("/add")
	public ResponseEntity<Nastavnik> addNastavnik (@RequestBody Nastavnik nastavnik){
		Nastavnik newNastavnik = nastavnikService.dodajNastavnika(nastavnik);
		
		return new ResponseEntity<>(newNastavnik,HttpStatus.CREATED);
		
	}
	/*
	@PutMapping("/update")
	public ResponseEntity<Nastavnik> updateNastavnik (@RequestBody Nastavnik nastavnik){
		Nastavnik updateNastavnik = nastavnikService.azurirajNastavnika(nastavnik);
		return new ResponseEntity<>(updateNastavnik,HttpStatus.OK);
		
	}
	*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateNastavnik (@PathVariable Long id, @RequestBody Nastavnik nastavnik){
		Nastavnik nastavnikZaCuvanje = nastavnikService.nadjiNastavnikaPoId(id).
				orElseThrow(()-> new RuntimeException("Ne postoji nastavnik sa id-jem: "+id));
		
		
		nastavnikZaCuvanje.setNastavnikId(nastavnik.getNastavnikId());
		nastavnikZaCuvanje.setImePrezime(nastavnik.getImePrezime());
		nastavnikZaCuvanje.setBrojTelefona(nastavnik.getBrojTelefona());
		nastavnikZaCuvanje.setStatus(nastavnik.getStatus());
		nastavnikZaCuvanje.setKatedra(nastavnik.getKatedra());
		
		Nastavnik updateNastavnik = nastavnikService.azurirajNastavnika(nastavnikZaCuvanje);
		return new ResponseEntity<>(updateNastavnik,HttpStatus.OK);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Nastavnik> getNastavnikById(@PathVariable Long id) {
		Nastavnik nastavnik = nastavnikService.nadjiNastavnikaPoId(id)
				.orElseThrow(()-> new RuntimeException("Ne postoji nastavnik sa id-jem: "+id));
		return new ResponseEntity<>(nastavnik,HttpStatus.OK);
	}

	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteNastavnik (@PathVariable("id") Long id){
		nastavnikService.deleteNastavnik(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
