package fr.m2i.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import fr.m2i.models.Client;
import fr.m2i.models.Coach;
import fr.m2i.models.Cours;



public class GestBDD {
	
	public static Connection connection;
	
	public void connection() {
		
		try {
	        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	        
	        //Connexion Adrien
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/bddglobogym", "root", "root");
	        
	        //Connexion Anaïs
	        // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddglobogym","root", null);
	        
	        
	        System.out.println("Connexion ok....");
	        
	        }
	        	        
		catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
			}
		
	}

	
	public static Connection getConnection() {
		if (connection == null) 
			new GestBDD();
		return connection;
	}
	
	
	public void close() {
		if (GestBDD.connection != null) {
			try {
				GestBDD.connection.close();
				GestBDD.connection = null; 
			}
			catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}
		
	}
	
	// GET ALL
	
    public List<Client> getAllClients () {       
        
    	List <Client> listeClients = new ArrayList<Client>();
           
  	  try {
          
          Statement stmt = connection.createStatement();            
          ResultSet rs = stmt.executeQuery("select * from client");
             
          while (rs.next()) {
                  String nom = rs.getString("nom");
                  String prenom = rs.getString("prenom");
                  Long id = rs.getLong("id");
                  Client client = new Client(id, nom, prenom);
                  listeClients.add(client);
          }
          
          rs.close();
          stmt.close();
         
          
  	  } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
  	  
  	  // Print the list to debug
  	for (Client element : listeClients) {
  	     System.out.println(element.getNom());
  	    }
  	
  	return listeClients;
  	  
  	  
    }
    

    public List<Coach> getAllCoaches () {       
    
    	List <Coach> listeCoaches = new ArrayList<Coach>();
       
    	try {
      
    		Statement stmt = connection.createStatement();            
    		ResultSet rs = stmt.executeQuery("select * from coach");
         
    		while (rs.next()) {
    			String nom = rs.getString("nom");
    			String prenom = rs.getString("prenom");
    			Long id = rs.getLong("id");
    			Coach coach = new Coach(id, nom, prenom);
    			listeCoaches.add(coach);
    		}
      
    		rs.close();
    		stmt.close();
     
      
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    }
	  
    	// Print the list to debug
    	for (Coach element : listeCoaches) {
    		System.out.println(element.getNom());
    		}
	
    	return listeCoaches;
	  
	  
}
    
    public List<Cours> getAllCours () {       
        
    	List <Cours> listeCours = new ArrayList<Cours>();
           
  	  	try {
          
  	  		Statement stmt = connection.createStatement();            
  	  		ResultSet rs = stmt.executeQuery("select * from cours");
             
  	  		while (rs.next()) {
  	  			Date date = rs.getDate("date");
  	  			Long id = rs.getLong("id");
  	  			Long coachId = rs.getLong("coach_id");
  	  			Long clientId = rs.getLong("client_id");
  	  			Cours cours = new Cours(id, date, coachId, clientId);
  	  			listeCours.add(cours);
  	  		}
          
  	  		rs.close();
  	  		stmt.close();
         
          
  	  	} catch (SQLException e) {
	        // TODO Auto-generated catch block
  	  		e.printStackTrace();
  	  	}
  	  
  	  // Print the list to debug
  	  	for (Cours element : listeCours) {
  	  		System.out.println(element.getDate());
  	  	}
  	
  	  	return listeCours;
  	
  	  
    }
    
    // ADD METHOD
    
    public void addClient(String nom, String prenom) {
    	
    	try {
			String sql = "INSERT INTO client (nom, prenom) VALUES (?, ?) ";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setString(1, nom);
			ps.setString(2, prenom);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    public void addCoach(String nom, String prenom) {
    	
    	try {
			String sql = "INSERT INTO coach (nom, prenom) VALUES (?, ?) ";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setString(1, nom);
			ps.setString(2, prenom);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    public void addCours(String date, int coachId, int clientId) {
    	
    	try {
			String sql = "INSERT INTO cours (date, coach_id, client_id) VALUES (?, ?, ?) ";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setDate(1, Date.valueOf(date));
			ps.setLong(2,coachId);
			ps.setLong(3,clientId);
			
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
	
	
}
