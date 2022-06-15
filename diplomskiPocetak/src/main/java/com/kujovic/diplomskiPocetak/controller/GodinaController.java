package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kujovic.diplomskiPocetak.entity.Godina;
import com.kujovic.diplomskiPocetak.service.GodinaService;

@RestController
@RequestMapping("/godina")
public class GodinaController {

	private final GodinaService godinaService;
	
	public GodinaController(GodinaService godinaService) {
		this.godinaService=godinaService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Godina>> getAllGodine(){
		List<Godina> godine = godinaService.pronadjiSveGodine();
		return new ResponseEntity<>(godine,HttpStatus.OK);
	}
	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Katedra> getKatedraById (@PathVariable("id") Long id){
//		Katedra katedra = katedraService.nadjiKatedruPoId(id);
//		return new ResponseEntity<>(katedra,HttpStatus.OK);
//		
//	}
	
	@PostMapping("/add")
	public ResponseEntity<Godina> addGodina (@RequestBody Godina godina){
		Godina newGodina = godinaService.dodajGodinu(godina);
		return new ResponseEntity<>(newGodina,HttpStatus.CREATED);
		
	}
	
	/*@PutMapping("/update/{id}")
	public ResponseEntity<?> updateKatedra (@PathVariable Long id, @RequestBody Katedra katedra){
		Katedra katedraZaCuvanje = katedraService.nadjiKatedruPoId(id).
				orElseThrow(()-> new RuntimeException("Ne postoji katedra sa id-jem: "+id));
		
		katedraZaCuvanje.setKatedraId(katedra.getKatedraId());
		katedraZaCuvanje.setNazivKatedre(katedra.getNazivKatedre());
		katedraZaCuvanje.setSkraceniNazivKatedre(katedra.getSkraceniNazivKatedre());
		
		Katedra updateKatedra = katedraService.azurirajKatedru(katedraZaCuvanje);
		return new ResponseEntity<>(updateKatedra,HttpStatus.OK);
		
	}*/
	
		@GetMapping("/get/{id}")
		public ResponseEntity<Godina> getGodinaById(@PathVariable Long id) {
			Godina godina = godinaService.nadjiGodinuPoId(id)
					.orElseThrow(()-> new RuntimeException("Ne postoji godina sa id-jem: "+id));
			return new ResponseEntity<>(godina,HttpStatus.OK);
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGdoina (@PathVariable("id") Long id){
		godinaService.deleteGodina(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
