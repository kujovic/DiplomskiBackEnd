package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kujovic.diplomskiPocetak.entity.Izvodjac;
import com.kujovic.diplomskiPocetak.entity.IzvodjacId;
import com.kujovic.diplomskiPocetak.entity.Katedra;
import com.kujovic.diplomskiPocetak.entity.Predmet;
import com.kujovic.diplomskiPocetak.service.IzvodjacService;
import com.kujovic.diplomskiPocetak.service.PredmetService;

@RestController
@RequestMapping("/izvodjac")
public class IzvodjacController {

private final IzvodjacService izvodjacService;
private final PredmetService predmetService;
	
	public IzvodjacController(IzvodjacService izvodjacService, PredmetService predmetService) {
		this.izvodjacService=izvodjacService;
		this.predmetService= predmetService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Izvodjac>> getAllIzvodjaci(){
		List<Izvodjac> izvodjaci = izvodjacService.pronadjiSveIzvodjace();
		return new ResponseEntity<>(izvodjaci,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addIzvodjac (@RequestBody Izvodjac izvodjac){
		Izvodjac newIzvodjac = izvodjacService.dodajIzvodjaca(izvodjac);
		return new ResponseEntity<>(newIzvodjac,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Izvodjac> updateIzvodjac (@RequestBody Izvodjac izvodjac){
		Izvodjac updateIzvodjac = izvodjacService.azurirajIzvodjaca(izvodjac);
		return new ResponseEntity<>(updateIzvodjac,HttpStatus.OK);
		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteNastavnik (@PathVariable("id") Long id){
		izvodjacService.deleteIzvodjac(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<Izvodjac>> getNastavnikById(@PathVariable Long id) {
		Predmet predmet = predmetService.nadjiPredmetPoId(id)
				.orElseThrow(()-> new RuntimeException("Ne postoji predmet sa id-jem: "+id));
		List<Izvodjac> izvodjac = izvodjacService.pronadjiSveIzvodjacePoPredmetu(id);
		for (Izvodjac i : izvodjac) {
			i.setPredmet(predmet);
			System.out.println(i.getNastavnik().getImePrezime());
		}
		
		
		return new ResponseEntity<>(izvodjac,HttpStatus.OK);
	}
	
//	@GetMapping("/getmax")
//	public ResponseEntity<Long> get() {
//		Long maxIzvodjac = izvodjacService.vratiMaxIzvodjacId();		
//		return new ResponseEntity<>(maxIzvodjac,HttpStatus.OK);
//	}
}
