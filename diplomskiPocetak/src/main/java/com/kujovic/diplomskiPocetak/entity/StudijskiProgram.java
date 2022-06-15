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
public class StudijskiProgram implements Serializable {
	@Id
	private Long studijskiProgramId;
	
	private String nazivStudijskogPrograma;
	
	private String skraceniNazivStudijskogPrograma;
}
