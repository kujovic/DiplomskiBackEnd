package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kujovic.diplomskiPocetak.entity.Katedra;
import com.kujovic.diplomskiPocetak.entity.Nastavnik;
import com.kujovic.diplomskiPocetak.service.KatedraService;


@RestController
@RequestMapping("/katedra")
public class KatedraController {
	private final KatedraService katedraService;
	
	public KatedraController(KatedraService katedraService) {
		this.katedraService=katedraService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Katedra>> getAllKatedre(){
		List<Katedra> katedre = katedraService.pronadjiSveKatedre();
		return new ResponseEntity<>(katedre,HttpStatus.OK);
	}
	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Katedra> getKatedraById (@PathVariable("id") Long id){
//		Katedra katedra = katedraService.nadjiKatedruPoId(id);
//		return new ResponseEntity<>(katedra,HttpStatus.OK);
//		
//	}
	
	@PostMapping("/add")
	public ResponseEntity<Katedra> addKatedra (@RequestBody Katedra katedra){
		Katedra newKatedra = katedraService.dodajKatedru(katedra);
		return new ResponseEntity<>(newKatedra,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateKatedra (@PathVariable Long id, @RequestBody Katedra katedra){
		Katedra katedraZaCuvanje = katedraService.nadjiKatedruPoId(id).
				orElseThrow(()-> new RuntimeException("Ne postoji katedra sa id-jem: "+id));
		
		katedraZaCuvanje.setKatedraId(katedra.getKatedraId());
		katedraZaCuvanje.setNazivKatedre(katedra.getNazivKatedre());
		katedraZaCuvanje.setSkraceniNazivKatedre(katedra.getSkraceniNazivKatedre());
		
		Katedra updateKatedra = katedraService.azurirajKatedru(katedraZaCuvanje);
		return new ResponseEntity<>(updateKatedra,HttpStatus.OK);
		
	}
	
		@GetMapping("/get/{id}")
		public ResponseEntity<Katedra> getKatedraById(@PathVariable Long id) {
			Katedra katedra = katedraService.nadjiKatedruPoId(id)
					.orElseThrow(()-> new RuntimeException("Ne postoji katedra sa id-jem: "+id));
			return new ResponseEntity<>(katedra,HttpStatus.OK);
		}
		
		
		@GetMapping("/getnastavnik/{id}")
		public ResponseEntity<List<Nastavnik>> getNastavnikeByKatedra(@PathVariable Long id) {
			List<Nastavnik> katedreNastavnikDTO = katedraService.nadjiNastavnikeNaKatedri(id);
			return new ResponseEntity<>(katedreNastavnikDTO,HttpStatus.OK);
		}
		
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteKatedra (@PathVariable("id") Long id){
		katedraService.deleteKatedra(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
