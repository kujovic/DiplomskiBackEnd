package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kujovic.diplomskiPocetak.entity.Uloga;
import com.kujovic.diplomskiPocetak.service.UlogaService;

@RestController
@RequestMapping("/uloga")
public class UlogaController {

	private final UlogaService ulogaService;
	
	public UlogaController(UlogaService ulogaService) {
		this.ulogaService=ulogaService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Uloga>> getAllUloge(){
		List<Uloga> uloge = ulogaService.pronadjiSveUloge();
		return new ResponseEntity<>(uloge,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Uloga> addUloga (@RequestBody Uloga uloga){		
		Uloga newUloga = ulogaService.dodajUlogu(uloga);
		return new ResponseEntity<>(newUloga,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUloga (@PathVariable("id") Long id){
		ulogaService.deleteUloga(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
