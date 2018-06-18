package it.dstech.SuperMarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

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
	
}