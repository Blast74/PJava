package Package;

import java.util.Arrays;

public class Expert extends Collaborateurs {
    private Mission[] missions;


    public Expert(int id, String nom, String prenom, String login, String password, String departement, String poste, Categorie cat, Langue[] lang, Mission[] missions) {
        super(id, nom, prenom, login, password, departement, poste, cat, lang);
        this.missions = missions;
    }

    public Expert(int id, String nom, String prenom, String login, String password, String departement, String poste, Categorie cat, Langue[] lang) {
        super(id, nom, prenom, login, password, departement, poste, cat, lang);
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void setMissions(Mission[] missions) {
        this.missions = missions;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "missions=" + Arrays.toString(missions) +
                ", id=" + id +
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
}
