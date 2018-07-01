package Package;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.Scanner;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class Main {

	public static void main(String[] args) {
		
		String urlBDD = "jdbc:mysql://localhost/devexpert?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String loginBDD = "root";
		String passBDD = "";
		
		Connection connexion = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Chargement des drivers");
			
			connexion = DriverManager.getConnection(urlBDD, loginBDD, passBDD);
			System.out.println("Connexion a la BDD");
			
			System.out.println("1 - Ajouter un collaborateur");
			System.out.println("2 - Modifier un collaborateur");
			System.out.println("3 - Supprimer un collaborateur");
			System.out.println("4 - Afficher un collaborateur");
			System.out.println("5 - Afficher les collaborateur par categorie");
			System.out.println("6 - Afficher les collaborateur par departement");
			System.out.println("7 - Calculer un salaire");
			System.out.println("9 - Quitter");
			int choixMenu = Clavier.lireInt();

			Scanner scanner = new Scanner(System.in);
			
			switch(choixMenu){
			  case 1:
					System.out.println("Entrez le nom");
					String nomADD = scanner.nextLine();
					System.out.println("Entrez le prenom");
					String prenomADD = scanner.nextLine();
					System.out.println("Entrez le login");
					String loginADD = scanner.nextLine();
					System.out.println("Entrez le mot de passe");
					String passwordADD = scanner.nextLine();

					
					System.out.println("Entrez la categorie");
					String categorieADD = scanner.nextLine();
					System.out.println("Entrez le departement");
					String departementADD = scanner.nextLine();
					Collaborateurs col = new Collaborateurs(nomADD,prenomADD, loginADD, passwordADD, departementADD , new Categorie(categorieADD),new Langue());
					statement = connexion.createStatement();    
					String sqlADD = "INSERT INTO collaborateur (name, firstname, login, password, department) VALUES ('"+ nomADD +"', '"+ prenomADD +"', '"+ loginADD +"', '"+ cryptedPassword +"', '"+ departementADD +"');";
					statement.execute(sqlADD);         
					System.out.println("Collaborateur ajoute");
					
				    break; 
			  case 2:
				  	System.out.println("Entrez le nom");
					String getnomUPD = scanner.nextLine();
					System.out.println("Entrez le prenom");
					String getprenomUPD = scanner.nextLine(); 
					
					statement = connexion.createStatement();    
					String sqlSelectUPD = "SELECT * FROM collaborateurs WHERE nom = '"+ getnomUPD +"' AND prenom = '"+ getprenomUPD +"' ";
					ResultSet resultUPD = statement.executeQuery(sqlSelectUPD);
		
					while(resultUPD.next()) {   
						int idUPD = resultUPD.getInt("id");
						String nomUPD = resultUPD.getString("nom");   
						String prenomUPD = resultUPD.getString("prenom"); 
						String loginUPD = resultUPD.getString("login");  
						String passwordUPD = resultUPD.getString("password");  
						String categorieUPD = resultUPD.getString("categorie");   
						String departementUPD = resultUPD.getString("departement"); 
						System.out.println("Vous souhaitez modifier "+ nomUPD +" - "+ prenomUPD +" - "+ categorieUPD +" - "+ departementUPD); 
					
					
					}
					break;
			  case 3:
				  	System.out.println("Entrez le nom");
					String nomDEL = scanner.nextLine();
					System.out.println("Entrez le prenom");
					String prenomDEL = scanner.nextLine();
					
					statement = connexion.createStatement();    
					String sqlDEL = "DELETE FROM collaborateurs WHERE nom = '"+ nomDEL +"' AND prenom = '"+ prenomDEL +"' ";
					statement.execute(sqlDEL);         
					System.out.println("Collaborateur supprim�");
				  	break;
			  case 4:
				  	System.out.println("Liste des collaborateurs");
					
					statement = connexion.createStatement();    
					String sqlAFF = "SELECT * FROM collaborateurs";
					ResultSet resultAFF = statement.executeQuery(sqlAFF);
					   
					while(resultAFF.next()) {   
						String nomAFF = resultAFF.getString("nom");   
						String prenomAFF = resultAFF.getString("prenom");   
						String categorieAFF = resultAFF.getString("categorie");   
						String departementAFF = resultAFF.getString("departement"); 
						System.out.println(nomAFF + " - " + prenomAFF + " - " + categorieAFF + " - " + departementAFF); 
					} 
				  	break;
			  case 5:
				  	System.out.println("Entrez la cat�gorie recherch�e");
				  	String nomCateg = scanner.nextLine();
					
					statement = connexion.createStatement();    
					String sqlAFFCateg = "SELECT * FROM collaborateurs WHERE categorie = '"+ nomCateg +"' ";
					ResultSet resultAFFCateg = statement.executeQuery(sqlAFFCateg);
					   
					while(resultAFFCateg.next()) {   
						String nomAFFCateg = resultAFFCateg.getString("nom");   
						String prenomAFFCateg = resultAFFCateg.getString("prenom");   
						String categorieAFFCateg = resultAFFCateg.getString("categorie");   
						String departementAFFCateg = resultAFFCateg.getString("departement"); 
						System.out.println(nomAFFCateg + " - " + prenomAFFCateg + " - " + categorieAFFCateg + " - " + departementAFFCateg); 
					} 
				  	break;
			  case 6:
				  	System.out.println("Entrez le d�partement recherch�");
				  	String nomDept = scanner.nextLine();
					
					statement = connexion.createStatement();    
					String sqlAFFDept = "SELECT * FROM collaborateurs WHERE categorie = '"+ nomDept +"' ";
					ResultSet resultAFFDept = statement.executeQuery(sqlAFFDept);
					   
					while(resultAFFDept.next()) {   
						String nomAFFDept = resultAFFDept.getString("nom");   
						String prenomAFFDept = resultAFFDept.getString("prenom");   
						String categorieAFFDept = resultAFFDept.getString("categorie");   
						String departementAFFDept = resultAFFDept.getString("departement"); 
						System.out.println(nomAFFDept + " - " + prenomAFFDept + " - " + categorieAFFDept + " - " + departementAFFDept); 
					} 
				  	break;
			  case 7:
				  	System.out.println("Calculer un salaire");
					break;
			  case 9:
				  	System.exit(0); 
				  	break;
			  default:
			               
			}
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
				statement.close();     
			}      
			catch (SQLException e) {      
				e.printStackTrace();     
			}
		}        
	}
}
