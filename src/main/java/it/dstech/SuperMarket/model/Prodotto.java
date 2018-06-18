package it.dstech.SuperMarket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity 
public class Prodotto extends Base{

	@Column(name="nome ", nullable = false , unique = false)
	private String nome;
	@Column(name="marca ", nullable = false , unique = false)
	private String marca;
	@Column(name="data_di_scadenza ", nullable = false , unique = false)
	private LocalDate dataDiScadenza;
	@JoinColumn(name="categoria ", nullable = false , unique = false)
	private Categoria categoria;
	@Column(name="quantita_disponibile ", nullable = false , unique = false)
	private int quantitaDisponibile;
	@JoinColumn(name="unita ", nullable = false , unique = false)
	private Unita unita;
	@Column(name="prezzo_unitario ", nullable = false , unique = false)
	private Double prezzoUnitario;
	@Column(name="prezzo_ivato ", nullable = false , unique = false)
	private Double prezzoIvato;
	@Column(name=" offerta", nullable = false , unique = false)
	private int offerta;



}
