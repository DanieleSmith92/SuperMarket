package it.dstech.SuperMarket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "storico")
public class Storico extends Base{
	
	@Column(name = "totale_spesa", nullable = false)
	private Double totale;
	
	@Column(name = "data", nullable = false)
	private LocalDate data;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn (name="user")
	@JsonIgnore
	private User user;
	
}
