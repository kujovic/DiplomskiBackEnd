package com.kujovic.diplomskiPocetak.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Predmet  implements Serializable{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  predmetId;
	
	private String nazivPredmeta;
	private int semestar;
	//private String studijskiProgram;
	//private String modul;
	private boolean obavezan;
	
	@ManyToOne
	private Katedra katedra;
	
	/*
	@OneToMany(mappedBy = "predmet")
	@JsonIgnore
	private List<Izvodjac> izvodjaci;*/
}
