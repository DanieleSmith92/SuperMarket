package it.dstech.SuperMarket.model;


import java.util.List;


import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.swing.text.Caret;

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
    @JoinColumn (name="profile_type")
	private UserProfile profileType;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	@JsonIgnore
	private List<CartaCredito>listaCarte;
	
	

			
	
	
	
	

    
    
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="storico")
    @JsonIgnore
    public Storico storico;

}