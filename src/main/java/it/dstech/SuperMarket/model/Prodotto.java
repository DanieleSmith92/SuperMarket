package it.dstech.SuperMarket.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity 
public class Prodotto extends Base{

	@Column(name="nome ", nullable = false , unique = false)
	private String nome;
	@Column(name="marca ", nullable = false , unique = false)
	private String marca;
	@Column(name="data_di_scadenza ", nullable = false , unique = false)
	private LocalDate dataDiScadenza;
	@Column(name="categoria ", nullable = false , unique = false)
	private Categoria categoria;
	@Column(name="quantita_disponibile ", nullable = false , unique = false)
	private int quantitaDisponibile;
	@Column(name="unita ", nullable = false , unique = false)
	private Unita unita;
	@Column(name="prezzo_unitario ", nullable = false , unique = false)
	private Double prezzoUnitario;
	@Column(name="prezzo_ivato ", nullable = false , unique = false)
	private Double prezzoIvato;
	@Column(name=" offerta", nullable = false , unique = false)
	private int offerta;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "prodotto_storico",
	joinColumns = {
			@JoinColumn(name ="prodotto_id", nullable = false, updatable = true)},
	inverseJoinColumns = {
			@JoinColumn(name = "storico_id", nullable = false, updatable = true)
	})
			private List<Storico> listaStorici;
	
	
	
	

}
