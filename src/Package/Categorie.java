package Package;

public class Categorie {

    public int id;
    public String name;

    public Categorie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categorie(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
