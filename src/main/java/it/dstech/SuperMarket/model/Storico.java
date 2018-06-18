package it.dstech.SuperMarket.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "storico")
public class Storico extends Base{
	
	@Column(name = "totale_spesa", nullable = false)
	private Double totale;
	
	@Column(name = "data" , nullable = false)
	private LocalDate data;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente", nullable=false)
	@JsonIgnore
	private List<Prodotto>listaProdotti;
}
