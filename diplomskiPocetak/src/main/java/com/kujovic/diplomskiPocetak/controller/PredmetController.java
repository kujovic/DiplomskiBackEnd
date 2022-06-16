package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kujovic.diplomskiPocetak.entity.Nastavnik;
import com.kujovic.diplomskiPocetak.entity.Predmet;
import com.kujovic.diplomskiPocetak.service.IzvodjacService;
import com.kujovic.diplomskiPocetak.service.PredmetService;

@RestController
@RequestMapping("/predmet")
public class PredmetController {

	private final PredmetService predmetService;

	public PredmetController(PredmetService predmetService) {
		this.predmetService=predmetService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Predmet>> getAllPredmete(){
		List<Predmet> predmeti = predmetService.pronadjiSvePredmete();
		return new ResponseEntity<>(predmeti,HttpStatus.OK);
	}
	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Predmet> getPredmetById (@PathVariable("id") Long id){
//		Predmet predmet = predmetService.nadjiPredmetPoId(id);
//		return new ResponseEntity<>(predmet,HttpStatus.OK);
//	}
//	
	@PostMapping("/add")
	public ResponseEntity<Predmet> addPredmet (@RequestBody Predmet predmet){
		Predmet newPredmet = predmetService.dodajPredmet(predmet);
		return new ResponseEntity<>(newPredmet,HttpStatus.CREATED);
	}
	
	
//	@PutMapping("/update")
//	public ResponseEntity<Predmet> updatePredmet (@RequestBody Predmet predmet){
//		Predmet updatePredmet = predmetService.azurirajPredmet(predmet);
//		return new ResponseEntity<>(updatePredmet,HttpStatus.OK);
//		
//	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePredmet (@PathVariable Long id, @RequestBody Predmet predmet){
		Predmet predmetZaCuvanje = predmetService.nadjiPredmetPoId(id).
				orElseThrow(()-> new RuntimeException("Ne postoji predmet sa id-jem: "+id));
		
		
		predmetZaCuvanje.setPredmetId(predmet.getPredmetId());
		predmetZaCuvanje.setNazivPredmeta(predmet.getNazivPredmeta());
		predmetZaCuvanje.setSemestar(predmet.getSemestar());
		predmetZaCuvanje.setObavezan(predmet.isObavezan());
		predmetZaCuvanje.setKatedra(predmet.getKatedra());
		
		
		Predmet updatePredmet = predmetService.azurirajPredmet(predmetZaCuvanje);
		return new ResponseEntity<>(updatePredmet,HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Predmet> getNastavnikById(@PathVariable Long id) {
		Predmet predmet = predmetService.nadjiPredmetPoId(id)
				.orElseThrow(()-> new RuntimeException("Ne postoji predmet sa id-jem: "+id));
		return new ResponseEntity<>(predmet,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePredmet (@PathVariable("id") Long id){
		predmetService.deletePredmet(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
