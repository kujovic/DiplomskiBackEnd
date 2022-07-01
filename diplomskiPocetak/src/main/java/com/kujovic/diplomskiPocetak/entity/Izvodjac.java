package com.kujovic.diplomskiPocetak.entity;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@IdClass(IzvodjacId.class)
public class Izvodjac implements Serializable {
	
	@Id
	private Long izvodjacId;
	
	@ManyToOne
	@JoinColumn(name="ulogaId")
	private Uloga uloga;
	
	@ManyToOne
	@JoinColumn(name="nastavnikId")
	private Nastavnik nastavnik;
	

	@ManyToOne
	
	@JoinColumn(name="predmetId")
	private Predmet  predmet;
	

	@ManyToOne
	@JoinColumn(name="godinaId")
	
	private Godina godina;
	
	

	@ManyToOne
	@JoinColumn(name="studijskiProgramId")
	private StudijskiProgram studijskiProgram;
	
	//private String opis;
	
//	@Id
//	@OneToMany(targetEntity = Predmet.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="p1_fk", referencedColumnName = "predmetId")
//	private int predmetId;
//	
//	@Id
//	@OneToMany(targetEntity = Nastavnik.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="n1_fk", referencedColumnName = "nastavnikId")
//	private int nastavnikId;
//	
//	@Id
//	@OneToMany(targetEntity = Uloga.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="u_fk", referencedColumnName = "ulogaId")
//	private int ulogaId;
//	
	private int semestar;
	private int pozicija;

}
