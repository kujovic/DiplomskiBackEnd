package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.StudijskiProgram;
import com.kujovic.diplomskiPocetak.repository.StudijskiProgramRepository;

@Service
public class StudijskiProgramService {

	private final StudijskiProgramRepository studijskiProgramRepository;

	@Autowired
	public StudijskiProgramService(StudijskiProgramRepository studijskiProgramRepository) {
		this.studijskiProgramRepository = studijskiProgramRepository;
	}
	
	public StudijskiProgram dodajStudijskiProgram(StudijskiProgram studijskiProgram) {
		return studijskiProgramRepository.save(studijskiProgram);
	}
	
	public List<StudijskiProgram> pronadjiSveStudijskePrograme(){
		return studijskiProgramRepository.findAll();
	}
	
	public StudijskiProgram azurirajStudijskiProgram(StudijskiProgram studijskiProgram) {
		return studijskiProgramRepository.save(studijskiProgram);
	}
	
	public Optional<StudijskiProgram> nadjiStudijskiProgramPoId(Long id) {
		return studijskiProgramRepository.findById(id);
				
	}
	
	public void deleteStudijskiProgram(Long id) {
		studijskiProgramRepository.deleteById(id);
	}
}
