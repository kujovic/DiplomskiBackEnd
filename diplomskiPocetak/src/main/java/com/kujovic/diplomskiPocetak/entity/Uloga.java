package com.kujovic.diplomskiPocetak.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Uloga  implements Serializable{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  ulogaId;
	
	
	private String vrstaUloge;
	
	/*
	@OneToMany(mappedBy = "uloga")
	private List<Izvodjac> izvodjaci;*/
}
