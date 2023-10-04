package fr.m2i.models;

public class Coach {

	//Champs
	
	private Long id;
	private String nom;
	private String prenom;
	
	//Getters et Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
					
	//Constructeur
	
	public Coach () {
		
	}
	
	public Coach(Long id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;		
	} 
	
	public Coach(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;		
	}
	
	
}
