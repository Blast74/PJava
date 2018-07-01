package Package;

import java.util.Scanner;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class Menu {

	public static Collaborateurs MenuAjouter() {
		
		Scanner scanner = new Scanner(System.in);
		Collaborateurs collaborateur = new Collaborateurs();
		
		System.out.println("Entrez le nom");
		String nomADD = scanner.nextLine();
		collaborateur.setNom(nomADD);
		System.out.println("Entrez le prenom");
		String prenomADD = scanner.nextLine();
		collaborateur.setPrenom(prenomADD);
		System.out.println("Entrez le login");
		String loginADD = scanner.nextLine();
		collaborateur.setLogin(loginADD);
		System.out.println("Entrez le mot de passe");
		String passwordADD = scanner.nextLine();
		collaborateur.setPassword(passwordADD);
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-256");
		passwordEncryptor.setPlainDigest( false );
		String cryptedPassword = passwordEncryptor.encryptPassword(passwordADD);
		
		System.out.println("Entrez la categorie");
		System.out.println("1- Expert technique");
		System.out.println("2- Comptable");
		System.out.println("3- Commerciaux");
		System.out.println("4- Secrétaire");
		
		int choixUser = Clavier.lireInt();
		
		Categorie categorie = new Categorie();
		
		switch(choixUser){
			case 1:
				categorie.setId(categorieIdADD);
				categorie.setName(categorieNameADD);
				break;
			case 2:
				categorie.setId(categorieIdADD);
				categorie.setName(categorieNameADD);
				break;
			case 3:
				categorie.setId(categorieIdADD);
				categorie.setName(categorieNameADD);
				break;
			case 4:
				categorie.setId(categorieIdADD);
				categorie.setName(categorieNameADD);
				break;
			default:
		}
		
		System.out.println("Entrez le departement");
		String departementADD = scanner.nextLine();
		collaborateur.setDepartement(departementADD);
		
		DataManager.creerCollaborateur(collaborateur);
		
		scanner.close();
		
		return collaborateur;
	}
}
