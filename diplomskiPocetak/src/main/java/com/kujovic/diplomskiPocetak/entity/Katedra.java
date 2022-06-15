package com.kujovic.diplomskiPocetak.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Katedra  implements Serializable{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  katedraId;
	
	private String nazivKatedre;
	
	private String skraceniNazivKatedre;
	
//	@OneToMany(targetEntity = Predmet.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="p_fk", referencedColumnName = "predmetId")
//	private List<Predmet> predmeti;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "nastavnikId")
	private List<Nastavnik> nastavnici;
	
	@JsonIgnore
	@OneToMany(mappedBy = "predmetId")
	private List<Predmet> predmeti;*/
	
//	@ManyToOne
//	private Izvodjac izvodjac;
}
