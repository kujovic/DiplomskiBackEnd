package com.kujovic.diplomskiPocetak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kujovic.diplomskiPocetak.entity.Katedra;
import com.kujovic.diplomskiPocetak.entity.Nastavnik;
import com.kujovic.diplomskiPocetak.repository.KatedraRepository;
import com.kujovic.diplomskiPocetak.repository.NastavnikRepository;

@Service
public class KatedraService {

	private final KatedraRepository katedraRepository;
	private final NastavnikRepository nastavnikRepository;

	@Autowired
	public KatedraService(KatedraRepository katedraRepository, NastavnikRepository nastavnikRepository) {
		this.katedraRepository = katedraRepository;
		this.nastavnikRepository = nastavnikRepository;
	}

	public Katedra dodajKatedru(Katedra katedra) {
		return katedraRepository.save(katedra);
	}

	public List<Katedra> pronadjiSveKatedre() {
		return katedraRepository.findAll();
	}

	public Katedra azurirajKatedru(Katedra katedra) {
		return katedraRepository.save(katedra);
	}

	public Optional<Katedra> nadjiKatedruPoId(Long id) {
		return katedraRepository.findById(id);

	}

	public List<Nastavnik> nadjiNastavnikeNaKatedri(Long id) {
		System.out.println(id);

		List<Nastavnik> list = nastavnikRepository.findNastavniciNaKatedri(id);
		System.out.println(list.size());

		for (Nastavnik entry : list) {
			System.out.println(entry.getImePrezime());
		}
		return list;

	}

	public void deleteKatedra(Long id) {
		katedraRepository.deleteById(id);
	}

}
