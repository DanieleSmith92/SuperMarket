package it.dstech.SuperMarket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name = "user")
public class User extends Base {

	@Column (name = "username", nullable = false, unique = true)
	private String username;
	
	@Column (name = "password", nullable = false, unique = true)
	private String password;
	
	@Column (name = "via", nullable = false, unique = false)
	private String via;
	
	@Column (name = "cap", nullable = false, unique = true)
	private String cap;
	
	@Column (name = "citta", nullable = false, unique = true)
	private String citta;
	
	@Column (name = "provincia", nullable = false, unique = true)
	private String prov;
	
	@Enumerated(EnumType.STRING)
	private UserProfile profileType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	@JsonIgnore
	private List<CartaCredito> listaCarte;
  
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="user")
    @JsonIgnore
    private List<Storico> listaStorici;

 
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public String getCap() {
		return cap;
	}


	public void setCap(String cap) {
		this.cap = cap;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String getProv() {
		return prov;
	}


	public void setProv(String prov) {
		this.prov = prov;
	}


	public UserProfile getProfileType() {
		return profileType;
	}


	public void setProfileType(UserProfile profileType) {
		this.profileType = profileType;
	}


	public List<CartaCredito> getListaCarte() {
		return listaCarte;
	}


	public void setListaCarte(List<CartaCredito> listaCarte) {
		this.listaCarte = listaCarte;
	}


	public List<Storico> getListaStorici() {
		return listaStorici;
	}


	public void setListaStorici(List<Storico> listaStorici) {
		this.listaStorici = listaStorici;
	}

}