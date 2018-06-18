package it.dstech.SuperMarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name = "user")
public class User extends Base {

	@Column (name = "username", nullable = false, unique = true)
	private String username;
	@Column (name = "password", nullable = false, unique = true)
	private String password;

	private UserProfile profileType;


	public UserProfile getProfileType() {
		return profileType;
	}

	public void setProfileType(UserProfile profileType) {
		this.profileType = profileType;
	}

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
}
