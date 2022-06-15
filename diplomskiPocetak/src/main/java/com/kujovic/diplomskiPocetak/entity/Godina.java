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
public class Godina implements Serializable {
	@Id
	private Long  godinaId;
	
	private String kalendarskaGodina;
}
