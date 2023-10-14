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
import fr.m2i.models.CoursType;
import fr.m2i.models.Reservation;
import fr.m2i.models.Utilisateur;



public class GestBDD {
	
	public static Connection connection;
	
	public Utilisateur utilisateur;
	
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
	

	//----------------CREATE----------------

    
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
    
    public void addCours(String date, int coachId, int courstypeId) {
    	
    	try {
			String sql = "INSERT INTO cours (date, coach_id,  courstype_id) VALUES (?, ?, ?) ";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setDate(1, Date.valueOf(date));
			ps.setLong(2,coachId);
			ps.setLong(3,courstypeId);
			ps.execute();
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
    }
    
    public void addClientToReservation(Client client, Cours cours) {
    	
    	try {
			String sql = "INSERT INTO reservation (client_id, cours_id) VALUES (?, ?);";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setLong(1, client.getId());
			ps.setLong(2, cours.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
    	
    }
    
    
	
	
  //----------------READ----------------
    
    public Client selectClient (Long id) {
    	
    	Client client = null;
    			
    	try {
    		String sql = "SELECT * FROM client WHERE id =?";
    		PreparedStatement ps = connection.prepareStatement (sql);
    		
    		ps.setLong(1, id);
    		
    		ResultSet rs= ps.executeQuery();
    		
    		while(rs.next()) {
    			String nom = rs.getString("nom");
    			String prenom = rs.getString("prenom");
    			client = new Client(id, nom, prenom);
    			
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
        }
        return client;
    	
    }
    
    public Coach selectCoach(Long id) {
        Coach coach = null;

        try {
            String sql = "SELECT * FROM coach WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                coach = new Coach(id, nom, prenom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coach;
    }
    
    public Cours selectCours(Long id) {
        Cours cours = null;
        

        try {
            String sql = "SELECT cours.id cours_id, cours.date cours_date, ct.ID courstype_id, ct.name courstype_name, co.id coach_id, co.nom coach_nom, co.prenom coach_prenom FROM cours LEFT JOIN courstype ct ON (cours.courstype_id = ct.id)LEFT JOIN coach co ON (cours.coach_id = co.id) WHERE cours.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Long cours_id = rs.getLong("cours_id");
            	Date date = rs.getDate("cours_date");
            	CoursType coursType = new CoursType(rs.getLong("coursType_id"), rs.getString("coursType_name"));
            	Coach coach = new Coach(rs.getLong("coach_id"), rs.getString("coach_nom"), rs.getString("coach_prenom"));
            	
                cours = new Cours(cours_id, date, coursType, coach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }
    
    

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
	        e.printStackTrace();
	    }

  	return listeClients;
   
    }
    

    public List<Coach> getAllCoaches() {
        List<Coach> listeCoaches = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coach");

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
            e.printStackTrace();
        }

        return listeCoaches;
    }      
    
       
    
    
public List <CoursType> getAllCoursType() {
		
		List <CoursType> listeCoursType = new ArrayList <CoursType>();
		
	 	  try {
	  		  
	          Statement stmt = connection.createStatement();            
	          ResultSet rs = stmt.executeQuery("select * from courstype");
	             
	          while (rs.next()) {
	                  String nom = rs.getString("name");
	                  Long id = rs.getLong("id");
	                  CoursType coursType = new CoursType(id, nom);
	                  listeCoursType.add(coursType);
	          }
	          
	          rs.close();
	          stmt.close();
	         
	          
	  	  } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	  	  
	  	  // Print the list to debug
	  
	  	return listeCoursType;
		
		
	}

    
    public List<Cours> getAllCours () {     
    	

        
    	List <Cours> listeCours = new ArrayList<Cours>();
           
  	  	try {
          
  	  		Statement stmt = connection.createStatement();            
  	  		ResultSet rs = stmt.executeQuery("SELECT cours.id cours_id, cours.date cours_date, c.id coach_id, c.nom coach_nom, c.prenom coach_prenom, ct.ID courstype_id, ct.name courstype_name   FROM cours LEFT JOIN coach c ON cours.coach_id = c.id LEFT JOIN courstype ct ON cours.courstype_id = ct.ID;");
             
  	  		while (rs.next()) {
  	  			Long id = rs.getLong("cours_id");
  	  			Date date = rs.getDate("cours_date");
  	  			Coach coach = new Coach(rs.getLong("coach_id"), rs.getString("coach_nom"), rs.getString("coach_prenom"));
  	  			CoursType coursType = new CoursType(rs.getLong("courstype_id"), rs.getString("courstype_name"));
  	  	
  				Cours cours = new Cours(id, date, coursType, coach);
  			
  		  	  	listeCours.add(cours);
  				
	  		}	
  	  		
  	  		rs.close();
  	  		stmt.close();
                   
  	  	} catch (SQLException e) {
  	  		e.printStackTrace();
  	  	}
  	    	 

  	  	return listeCours; 	  
    }
    
    
    public void getNbClientsFromCours(Cours cours) {
    	
    	int nbClients = 0;
    	
	  	try {
			  
	    	String sql = "SELECT * FROM reservation WHERE reservation.cours_id = ?";
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    
	    	ps.setLong(1, cours.getId());
	    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	while (rs.next()) {
	    		nbClients += 1;
	    	}
	    			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	cours.setNbClients(nbClients);
    	
    	
    }
    
    public List<Client> getAllClientsFromCours(Cours cours) {     
    	
        
    	List <Client> listeClients = new ArrayList<Client>();
           
  	  	try {
          
  	  		           
  	  		String sql = "SELECT client_id, nom nom_client, prenom prenom_client FROM reservation LEFT JOIN client c ON reservation.client_id = c.id WHERE cours_id = ?";
  	  		PreparedStatement ps = connection.prepareStatement (sql);
  	  		
  	  		ps.setLong(1, cours.getId() );
  	  		
  	  		ResultSet rs = ps.executeQuery();
  	  		
  	  		while (rs.next()) {
  	  			Long clientId = rs.getLong("client_id");
  	  			String nomClient = rs.getString("nom_client");
  	  			String prenomClient = rs.getString("prenom_client");
  	  			Client client = new Client(clientId, nomClient, prenomClient);
  				
  	  			listeClients.add(client);
	  		}	
  	  		
  	  		rs.close();
  	  		ps.close();
                   
  	  	} catch (SQLException e) {
  	  		e.printStackTrace();
  	  	}
  	
  	  	return listeClients; 	  
    }
    
public List<Client> getAllClientsNotInCours(Cours cours) {     
    	
        
    	List <Client> listeClients = new ArrayList<Client>();
           
  	  	try {
          
  	  		           
  	  		String sql = "SELECT c.id client_id, c.nom AS nom_client, c.prenom AS prenom_client FROM client c WHERE c.id NOT IN (SELECT r.client_id FROM reservation r WHERE r.cours_id = ?);";
  	  		PreparedStatement ps = connection.prepareStatement (sql);
  	  		
  	  		ps.setLong(1, cours.getId() );
  	  		
  	  		ResultSet rs = ps.executeQuery();
  	  		
  	  		while (rs.next()) {
  	  			Long clientId = rs.getLong("client_id");
  	  			String nomClient = rs.getString("nom_client");
  	  			String prenomClient = rs.getString("prenom_client");
  	  			Client client = new Client(clientId, nomClient, prenomClient);
  				
  	  			listeClients.add(client);
	  		}	
  	  		
  	  		rs.close();
  	  		ps.close();
                   
  	  	} catch (SQLException e) {
  	  		e.printStackTrace();
  	  	}
  	
  	  	return listeClients; 	  
    }
    
    
 
    
  //----------------UPDATE----------------

    public void updateClient (Long id, String nom, String prenom) throws SQLException {
    	
    	try {

    		String sql = "UPDATE client SET nom=?, prenom=? WHERE id=?; ";		
    		PreparedStatement ps = connection.prepareStatement (sql);
    		
    		ps.setString(1, nom);
    		ps.setString(2, prenom);
    		ps.setLong(3,id);

    		ps.execute();
    		ps.close();
        
    	} catch (SQLException e) {
    		e.printStackTrace();
        }   
    	
    }
    
    public void updateCoach(Long id, String nom, String prenom) throws SQLException {
        try {
            String sql = "UPDATE coach SET nom=?, prenom=? WHERE id=?; ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setLong(3, id);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     
    
  //----------------DELETE----------------
 
   public void deleteClient(long id) {
	   try {
		   String sql="DELETE FROM client WHERE id=?";
		   PreparedStatement ps = connection.prepareStatement (sql);
		   
		   ps.setLong(1, id);
		   
		   ps.execute();
		   ps.close();
		   
	   } 
	   
	   catch (SQLException e) {
		   e.printStackTrace();
   		}
   }
   
   public void deleteClientFromReservation(Client client, Cours cours) {
	   try {
		   String sql="DELETE FROM reservation WHERE client_id = ? AND cours_id = ?;";
		   PreparedStatement ps = connection.prepareStatement (sql);
		   
		   ps.setLong(1, client.getId());
		   ps.setLong(2, cours.getId());
		   
		   ps.execute();
		   ps.close();
		   
	   } 
	   
	   catch (SQLException e) {
		   e.printStackTrace();
   		}
   }
   
     
   public void deleteCoach(long id) {
	   try {
		   String sql="DELETE FROM coach WHERE id=?";
		   PreparedStatement ps = connection.prepareStatement (sql);
		   
		   ps.setLong(1, id);
		   
		   ps.execute();
		   ps.close();
		   
	   } 	   
	   catch (SQLException e) {
		   e.printStackTrace();
   		}
   }
   
   public void deleteCours(long id) {
	   
	  
	   try {
		   String sql="DELETE FROM cours WHERE id=?";
		   PreparedStatement ps = connection.prepareStatement (sql);
		   
		   ps.setLong(1, id);
		   
		   ps.execute();
		   ps.close();
		   
	   } 	   
	   catch (SQLException e) {
		   e.printStackTrace();
   		}
   }
   
 
  
    
    
   //  
    
     
    
    
    public Utilisateur findUser(String email, String motdepasse){	
    	
		try {
			String SQL = "SELECT * FROM utilisateur WHERE email = ? AND motdepasse = ?";
			PreparedStatement ps;
			ps = connection.prepareStatement(SQL);
			ps.setString(1, email);
			ps.setString(2, motdepasse);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				utilisateur = new Utilisateur(rs.getLong("id"), rs.getString("email"), rs.getString("motdepasse"));
			}
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utilisateur;
	}
	
    
public boolean userExist(String email, String motdepasse) {
		
		boolean exist = false ;
		
		
		try {
			String SQL = "SELECT * FROM utilisateur WHERE email = ? AND motdepasse = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setString(1, email);
			ps.setString(2, motdepasse);
			
			ResultSet rs = ps.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
			} 
			else {
				exist = true;
			}
			

			
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exist;
		
		
	}



	
	
}
