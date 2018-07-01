package Package;

public class Langue {
    public int id;
    public String name;
    public int exp ;

    public Langue() {
    }

    public Langue(int id, String name, int exp) {
        this.id = id;
        this.name = name;
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
