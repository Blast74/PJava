package Package;

import java.util.Arrays;

public class Collaborateurs {
    protected int id;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	protected String departement;
	protected String poste;
	protected Categorie cat;
	protected Langue[] lang;

    public Collaborateurs() {
    }

    public Collaborateurs(int id, String nom, String prenom, String login, String password, String departement, String poste, Categorie cat, Langue[] lang) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.departement = departement;
        this.poste = poste;
        this.cat = cat;
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    public Langue[] getLang() {
        return lang;
    }

    public void setLang(Langue[] lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Collaborateurs{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", departement='" + departement + '\'' +
                ", poste='" + poste + '\'' +
                ", cat=" + cat +
                ", lang=" + Arrays.toString(lang) +
                '}';
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


}
