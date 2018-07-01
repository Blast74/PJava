package Package;

import java.util.Arrays;
import java.util.Date;

public class Mission {
    public int id;
    public Client[] clients;
    public Date dateBegin;
    public Date dateEnd;
    public int nbHeure;

    public Mission(int id, Client[] clients, Date dateBegin, Date dateEnd, int nbHeure) {
        this.id = id;
        this.clients = clients;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.nbHeure = nbHeure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getNbHeure() {
        return nbHeure;
    }

    public void setNbHeure(int nbHeure) {
        this.nbHeure = nbHeure;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", clients=" + Arrays.toString(clients) +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", nbHeure=" + nbHeure +
                '}';
    }
}
