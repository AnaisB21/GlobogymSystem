package fr.m2i.models;

import java.util.List;

public class Reservation {
	
	private Long id, clientId, coursId;
	private Cours cours;
	private List <Client> listeClients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getCoursId() {
		return coursId;
	}

	public void setCoursId(Long coursId) {
		this.coursId = coursId;
	}

	public Reservation(Long id, Long clientId, Long coursId) {
		this.id = id;
		this.clientId = clientId;
		this.coursId = coursId;
	}
	
	public Reservation(Long clientId, Long coursId) {
		this.clientId = clientId;
		this.coursId = coursId;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public List <Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List <Client> listeClients) {
		this.listeClients = listeClients;
	}



}
