package Package;

import java.util.Arrays;

public class Expert extends Collaborateurs {
    private Mission[] missions;
    private int txHoraire = 20;

    public Expert() {
    }

    public Expert(Mission[] missions, int txHoraire) {
        this.missions = missions;
        this.txHoraire = txHoraire;
    }

    public Expert(int id, String nom, String prenom, String login, String password, String departement, Categorie cat, Langue[] lang, int salaire, Mission[] missions, int txHoraire) {
        super(id, nom, prenom, login, password, departement, cat, lang, salaire);
        this.missions = missions;
        this.txHoraire = txHoraire;
    }

    public Expert(String nom, String prenom, String login, String password, String departement, Categorie cat, Langue[] lang, int salaire, Mission[] missions, int txHoraire) {
        super(nom, prenom, login, password, departement, cat, lang, salaire);
        this.missions = missions;
        this.txHoraire = txHoraire;
    }

    public Expert(Mission[] missions) {
        this.missions = missions;
    }

    public Expert(int id, String nom, String prenom, String login, String password, String departement, Categorie cat, Langue[] lang, int salaire, Mission[] missions) {
        super(id, nom, prenom, login, password, departement, cat, lang, salaire);
        this.missions = missions;
    }

    public Expert(String nom, String prenom, String login, String password, String departement, Categorie cat, Langue[] lang, int salaire, Mission[] missions) {
        super(nom, prenom, login, password, departement, cat, lang, salaire);
        this.missions = missions;
    }



    @Override
    public int getSalaire(){
        int res = 0;
        for (Mission mis: this.missions) {
            res += mis.nbHeure * this.txHoraire;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "missions=" + Arrays.toString(missions) +
                ", txHoraire=" + txHoraire +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", departement='" + departement + '\'' +
                ", cat=" + cat +
                ", lang=" + Arrays.toString(lang) +
                ", salaire=" + salaire +
                '}';
    }
}
