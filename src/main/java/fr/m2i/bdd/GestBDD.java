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
            String sql = "SELECT * FROM cours WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Date date = rs.getDate("date");
            	Long coachId = rs.getLong("coach_id");
            	Long courstypeId = rs.getLong("courstype_id");
                
                cours = new Cours(id, date, coachId, courstypeId);
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
  	  		ResultSet rs = stmt.executeQuery("SELECT * FROM cours");
             
  	  		while (rs.next()) {
  	  			Long id = rs.getLong("id");
  	  			Date date = rs.getDate("date");
  	  			Long coachId = rs.getLong("coach_id");
  	  			Long courstypeId = rs.getLong("courstype_id");
  	  	
  				Cours cours = new Cours(id, date, coachId, courstypeId);
  			
  		  	  	listeCours.add(cours);
  				
	  		}	
  	  		
  	  		rs.close();
  	  		stmt.close();
                   
  	  	} catch (SQLException e) {
  	  		e.printStackTrace();
  	  	}
  	    	 

  	
  	  	return listeCours; 	  
    }
    
    public List<Long> getAllClientIdFromCours(Cours cours) {     
    	
        
    	List <Long> listeClientId = new ArrayList<Long>();
           
  	  	try {
          
  	  		           
  	  		String sql = "SELECT * FROM reservation WHERE cours_id = ?";
  	  		PreparedStatement ps = connection.prepareStatement (sql);
  	  		
  	  		ps.setLong(1, cours.getId() );
  	  		
  	  		ResultSet rs = ps.executeQuery();
  	  		
  	  		while (rs.next()) {
  	  			Long clientId = rs.getLong("client_id");
  	  			listeClientId.add(clientId);
  				
	  		}	
  	  		
  	  		rs.close();
  	  		ps.close();
                   
  	  	} catch (SQLException e) {
  	  		e.printStackTrace();
  	  	}
  	
  	  	return listeClientId; 	  
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
   
 
   
    public void removeClientFromCours(Client client, Cours cours) {
    	try {
    		String sql = "DELETE FROM cours WHERE client_id = ? ";
    		PreparedStatement ps = connection.prepareStatement (sql);
    		
    		ps.setLong(1, client.getId());
			
			ps.execute();
			ps.close();
    	}
    	
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }   
    
    
   //  
    
    public int countClientsInCours(Cours cours) {
    	
    	int count = 0;
    
    	try {
    		String sql = "SELECT * FROM cours WHERE date = ? AND coach_id = ? AND courstype_id = ?";
    		PreparedStatement ps = connection.prepareStatement(sql);   
    		
    		ps.setDate(1, (Date) cours.getDate());
    		ps.setLong(2, cours.getCoachId());
    		ps.setLong(3, cours.getCourstypeId());
    		
    		
    		ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				count ++;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return count;
    	
    }   
    
    
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
