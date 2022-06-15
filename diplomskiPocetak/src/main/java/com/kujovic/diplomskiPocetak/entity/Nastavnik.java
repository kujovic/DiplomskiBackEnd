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
public class Nastavnik  implements Serializable{
	
	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  nastavnikId;
	
	private String imePrezime;
	private String brojTelefona;
	private String status; //profesor,docent
	
	@ManyToOne
	private Katedra katedra;
	
	/*
	@OneToMany(mappedBy = "nastavnik")
	@JsonIgnore
	private List<Izvodjac> izvodjaci;
	*/
}
