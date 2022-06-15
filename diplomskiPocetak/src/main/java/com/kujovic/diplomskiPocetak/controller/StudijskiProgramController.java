package com.kujovic.diplomskiPocetak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kujovic.diplomskiPocetak.entity.StudijskiProgram;
import com.kujovic.diplomskiPocetak.service.StudijskiProgramService;

@RestController
@RequestMapping("/studijskiprogram")
public class StudijskiProgramController {

	private final StudijskiProgramService studijskiProgramService;
	
	public StudijskiProgramController(StudijskiProgramService studijskiProgramService) {
		this.studijskiProgramService=studijskiProgramService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<StudijskiProgram>> getAllStudijskiProgram(){
		List<StudijskiProgram> studijskiProgrami = studijskiProgramService.pronadjiSveStudijskePrograme();
		return new ResponseEntity<>(studijskiProgrami,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<StudijskiProgram> addStudijskiProgram (@RequestBody StudijskiProgram studijskiProgram){
		StudijskiProgram newStudijskiProgram = studijskiProgramService.dodajStudijskiProgram(studijskiProgram);
		return new ResponseEntity<>(newStudijskiProgram,HttpStatus.CREATED);
		
	}
	
		@GetMapping("/get/{id}")
		public ResponseEntity<StudijskiProgram> getStudijskiProgramById(@PathVariable Long id) {
			StudijskiProgram studijskiProgram = studijskiProgramService.nadjiStudijskiProgramPoId(id)
					.orElseThrow(()-> new RuntimeException("Ne postoji studijski program sa id-jem: "+id));
			return new ResponseEntity<>(studijskiProgram,HttpStatus.OK);
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudijskiProgram (@PathVariable("id") Long id){
		studijskiProgramService.deleteStudijskiProgram(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
