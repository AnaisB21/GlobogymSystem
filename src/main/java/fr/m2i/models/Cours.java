package fr.m2i.models;

public class Cours {

	//Champs
	
	private Long id;
	private Long date;
		
	//Getters et Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	
	//Constructeur
	
	public Cours(Long id, Long date) {
		this.id = id;
		this.date = date;
	}
}
