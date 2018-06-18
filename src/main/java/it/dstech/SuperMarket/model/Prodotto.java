package it.dstech.SuperMarket.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
	@Enumerated
	private Categoria categoria;
	@Column(name="quantita_disponibile ", nullable = false , unique = false)
	private int quantitaDisponibile;
	@Enumerated
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
			@JoinColumn(name = "storico_id", nullable = false, updatable = true)}
	)
	private List<Storico> listaStorici;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getDataDiScadenza() {
		return dataDiScadenza;
	}

	public void setDataDiScadenza(LocalDate dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public Unita getUnita() {
		return unita;
	}

	public void setUnita(Unita unita) {
		this.unita = unita;
	}

	public Double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(Double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public Double getPrezzoIvato() {
		return prezzoIvato;
	}

	public void setPrezzoIvato(Double prezzoIvato) {
		this.prezzoIvato = prezzoIvato;
	}

	public int getOfferta() {
		return offerta;
	}

	public void setOfferta(int offerta) {
		this.offerta = offerta;
	}

	public List<Storico> getListaStorici() {
		return listaStorici;
	}

	public void setListaStorici(List<Storico> listaStorici) {
		this.listaStorici = listaStorici;
	}
	
	
	

}
