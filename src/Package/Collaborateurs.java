package Package;

import java.sql.ResultSet;
import java.util.Scanner;

public class Collaborateurs {

	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	protected String departement;
	protected String categorie;
	protected int nbHeure;
	
	public Collaborateurs() {
		
	}

	public Collaborateurs(String nom, String prenom, String login, String password, String departement, String categorie, int nbHeure) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.departement = departement;
		this.categorie = categorie;
		this.nbHeure = nbHeure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String type) {
		this.categorie = type;
	}

	public int getNbHeure() {
		return nbHeure;
	}

	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}
	
	static Scanner scanner = new Scanner(System.in);
	
	static void ajouterCollaborateur() {
		System.out.println("Entrez le nom");
		String nom = scanner.nextLine();
		System.out.println("Entrez le prenom");
		String prenom = scanner.nextLine();
		System.out.println("Entrez le login");
		String login = scanner.nextLine();
		System.out.println("Entrez le mot de passe");
		String password = scanner.nextLine();
		System.out.println("Entrez la categorie");
		String categorie = scanner.nextLine();
		System.out.println("Entrez le département");
		String departement = scanner.nextLine();
		
		System.out.println(nom + prenom + login + password + categorie + departement);
	}
	
	static void modifierCollaborateur() {
		
	}
	
	static void supprimerCollaborateur() {
		
	}
	
	static void afficherCollaborateur() {
		
	}
	
	static void afficherCategorieCollaborateur() {
		
	}
	
	static void afficherDepartementCollaborateur() {
		
	}

	@Override
	public String toString() {
		return "Employes [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
				+ ", departement=" + departement + ", categorie=" + categorie + ", nbHeure=" + nbHeure + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ ", getDepartement()=" + getDepartement() + ", getCategorie()=" + getCategorie() + ", getNbHeure()="
				+ getNbHeure() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
