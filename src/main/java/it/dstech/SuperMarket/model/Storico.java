package it.dstech.SuperMarket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "storico")
public class Storico extends Base{
	
	@Column(name = "totale_spesa", nullable = false)
	private Double totale;
	
	@Column(name = "data" , nullable = false)
	private LocalDate data;

}
