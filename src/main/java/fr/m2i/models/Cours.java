package fr.m2i.models;


import java.util.Date;



public class Cours {

	//Champs
	
	private Long id, coachId, courstypeId;
	private Date date;
	private Coach coach;
	private CoursType coursType;
	private int nbClients;

	
		
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
	
	public Long getCourstypeId() {
		return courstypeId;
	}
	public void setCourstypeId(Long courstypeId) {
		this.courstypeId = courstypeId;
	}
	public Coach getCoach() {
	      return coach;
	   }

	public void setCoach(Coach coach) {
	      this.coach = coach;
	    }
	
	public CoursType getCoursType() {
		return coursType;
	}
	
	public void setCoursType(CoursType coursType) {
		this.coursType = coursType;
	};
	
		
	
	//Constructeur
	
	public Cours(Long id, Date date, Long coachId, Long courstypeId) {
		this.id = id;
		this.date = date;
		this.coachId = coachId;
		this.courstypeId = courstypeId;
	}
	
	public Cours(Date date, Long coachId, Long courstypeId) {
		this.date = date;
		this.coachId = coachId;
		this.courstypeId = courstypeId;
	}
	
	public Cours(Long id, Date date, CoursType coursType, Coach coach) {
		this.id = id;
		this.date = date;
		this.coursType = coursType;
		this.coach = coach;
	}
	public int getNbClients() {
		return nbClients;
	}
	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}

}
