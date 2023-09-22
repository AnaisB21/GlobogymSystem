package fr.m2i.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GestBDD {
	
	public static Connection connection;
	
	public void connection() {
		
		try {
	        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	        
	        //Connexion Adrien
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/formation", "root", "root");
	        
	        //Connexion Anaïs
	        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formation","root", null);
	        
	        
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
	
	
	
	
	
	
}
