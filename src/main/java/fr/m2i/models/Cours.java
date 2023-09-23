package fr.m2i.models;

import java.util.Date;

public class Cours {

	//Champs
	
	private Long id, coachId, clientId, courstypeId;
	private Date date;
		
	//Getters et Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCoachId() {
		return coachId;
	}
	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getCourstypeId() {
		return courstypeId;
	}
	public void setCourstypeId(Long courstypeId) {
		this.courstypeId = courstypeId;
	}
	
	
	//Constructeur
	
	public Cours(Long id, Date date, Long coachId, Long clientId, Long courstypeId) {
		this.id = id;
		this.date = date;
		this.coachId = coachId;
		this.clientId = clientId;
		this.courstypeId = courstypeId;
	}

	
}
