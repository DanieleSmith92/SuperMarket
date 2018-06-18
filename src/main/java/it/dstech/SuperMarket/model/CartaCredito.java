package it.dstech.SuperMarket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="CartaCredito")
public class CartaCredito extends Base{

	@Column(name= "numero_carta",nullable = false, unique= true)
	private String numero;

	@Column(name="data_scadenza",nullable = false)
	private LocalDate data;

	@Column(name="cvv",nullable = false)
	private String cvv;

	@Column(name="credito",nullable = false)
	private double credito;

 @ManyToOne (fetch = FetchType.LAZY)
 @JoinColumn (name="user")
 @JsonIgnore
 
 private User user;
 
 


}
