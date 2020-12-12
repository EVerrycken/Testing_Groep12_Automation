package domain.model;

public class Categorie {
    String naam;


    public Categorie(String naam){
        setNaam(naam);
    }

    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
}
