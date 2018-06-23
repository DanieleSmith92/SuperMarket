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
	
	/* quando metto in relazione due liste con una ManyToMany la relazione
	 * @ManyToMany va messa solo da una parte,altrimneti crea 3 tabelle
	 * se legassi invece una lista con un solo oggetto la posso mettere su entrambi
	*/
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaStorici")
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

	
	public List<Prodotto> getListaProdottiAcqustati() {
		return listaProdottiAcqustati;
	}

	public void setListaProdottiAcqustati(List<Prodotto> listaProdottiAcqustati) {
		this.listaProdottiAcqustati = listaProdottiAcqustati;
	}
	
	
}
