package fr.m2i.models;

public class Utilisateur {

	//Champs
	
	private Long id;
	private String email;
	private String motdepasse;
	
	//Getters et Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	//Constructeur
	
	public Utilisateur(Long id, String email, String motdepasse) {
		this.id = id;
		this.email = email;
		this.motdepasse = motdepasse;
		
	}
}
