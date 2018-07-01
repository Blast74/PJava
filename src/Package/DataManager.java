package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class DataManager {
	
	public static void statement(){
		
		String urlBDD = "jdbc:mysql://localhost/devexpert?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String loginBDD = "root";
		String passBDD = "";
		
		Connection connexion = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connexion = DriverManager.getConnection(urlBDD, loginBDD, passBDD);
			
			
		}
		catch (SQLException e) {     
			e.printStackTrace();    
		}    
		catch (ClassNotFoundException e) {          
			e.printStackTrace();
		}
		finally {     
			try {     
				connexion.close();           
			}      
			catch (SQLException e) {      
				e.printStackTrace();     
			}
		} 
	}
	
	public static Statement initBDD(){
   	 
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try{
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava?allowMultiQueries=true","root","");            
            Statement statement = connexion.createStatement();
 
            return statement;
        } catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }

	public static void creerCollacorateur(Collaborateurs collaborateur){
		
		Statement statement = initBDD();
		
		try{
			System.out.println("Créer un collaborateurs");
		    
			String sqlAddCollaborateur = "INSERT INTO collaborateurs (nom, prenom, login, password, id_cat, departement) "
					+ "VALUES ('"+ collaborateur.nom +"', '"+ collaborateur.prenom +"', '"+ collaborateur.login +"', '"+ collaborateur.getEncryptPassword() +"', '"+ collaborateur.cat +"', '"+ collaborateur.departement +"');"; 
			statement.execute(sqlAddCollaborateur);
			
			statement.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifierCollacorateur(Collaborateurs collaborateur){
		Statement statement = initBDD();
		
		try{
			System.out.println("Modifier un collaborateur");
			  
			String sqlAddCollaborateur = "INSERT INTO collaborateurs (nom, prenom, login, password, id_cat, departement) "
					+ "VALUES ('"+ collaborateur.nom +"', '"+ collaborateur.prenom +"', '"+ collaborateur.login +"', '"+ collaborateur.getEncryptPassword() +"', '"+ collaborateur.cat +"', '"+ collaborateur.departement +"');"
					+ "INNER JOIN speak ON id_col = id=col";  
			statement.execute(sqlAddCollaborateur);
			
			statement.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void supprimerCollacorateur(Collaborateurs collaborateur){
		Statement statement = initBDD();
		
		try {
			System.out.println("Supprimer des collaborateurs");
			    
			String sqlAFF = "DELETE FROM collaborateurs WHERE nom = '"+ collaborateur.nom +"' AND prenom = '"+ collaborateur.prenom +"'  "
													   + "INNER JOIN speak ON id_col = id_col"
													   + "INNER JOIN work ON id_col = id_col";
			ResultSet resultAFF = statement.executeQuery(sqlAFF);
			   
			statement.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void afficherCollacorateur(){
		Statement statement = initBDD();
		
		try {
			System.out.println("Liste des collaborateurs");
			 
			String sqlAFF = "SELECT * FROM collaborateurs INNER JOIN category ON id_cat = id_cat"
													   + "INNER JOIN speak ON id_col = id_col"
													   + "INNER JOIN work ON id_col = id_col";
			ResultSet resultAFF = statement.executeQuery(sqlAFF);
			   
			while(resultAFF.next()) {   
				int idAFF = resultAFF.getInt("id");
				String nomAFF = resultAFF.getString("nom");   
				String prenomAFF = resultAFF.getString("prenom");   
				String categorieAFF = resultAFF.getString("categorie");   
				String departementAFF = resultAFF.getString("departement"); 
				System.out.println(idAFF + " - " + nomAFF + " - " + prenomAFF + " - " + categorieAFF + " - " + departementAFF); 
			} 
			statement.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void afficherListeCollacorateurCategory(int cat){
		Statement statement = initBDD();
		
		try {
			System.out.println("Liste des collaborateurs par categorie");
			
			String sqlAFF = "SELECT FROM collaborateurs WHERE id_cat = '"+ cat +"'  "
													   + "INNER JOIN speak ON id_col = id_col"
													   + "INNER JOIN work ON id_col = id_col";
			ResultSet resultAFF = statement.executeQuery(sqlAFF);
			   
			while(resultAFF.next()) {   
				String nomAFF = resultAFF.getString("nom");   
				String prenomAFF = resultAFF.getString("prenom");   
				String categorieAFF = resultAFF.getString("categorie");   
				String departementAFF = resultAFF.getString("departement"); 
				System.out.println(nomAFF + " - " + prenomAFF + " - " + categorieAFF + " - " + departementAFF); 
			} 
			statement.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void afficherListeCollacorateurDepartement(String departement){
		Statement statement = initBDD();
		
		try {
			System.out.println("Liste des collaborateurs");
			
			String sqlAFF = "DELETE FROM collaborateurs WHERE departement = '" + departement + "' "
		   							    + "INNER JOIN speak ON id_col = id_col"
									    + "INNER JOIN work ON id_col = id_col";
			ResultSet resultAFF = statement.executeQuery(sqlAFF);
			   
			while(resultAFF.next()) {   
				String nomAFF = resultAFF.getString("nom");   
				String prenomAFF = resultAFF.getString("prenom");   
				String categorieAFF = resultAFF.getString("categorie");   
				String departementAFF = resultAFF.getString("departement"); 
				System.out.println(nomAFF + " - " + prenomAFF + " - " + categorieAFF + " - " + departementAFF); 
			} 
			statement.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
