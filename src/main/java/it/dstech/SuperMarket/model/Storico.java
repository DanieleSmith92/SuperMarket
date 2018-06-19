package it.dstech.SuperMarket.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "prodotti_acquistati")
	@JsonIgnore
	private List<Prodotto> listaProdottiAcqustati;

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
