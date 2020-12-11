package domain.model;

public class Eten {
    private String naam;
    private double prijs;
    private String categorie;
    private String extrainfo;

    public Eten(String naam, double prijs, String categorie, String extrainfo){
        setNaam(naam);
        setPrijs(prijs);
        setCategorie(categorie);
        setExtrainfo(extrainfo);
    }

    public void setCategorie(String categorie) {
        if (categorie == null || categorie.trim().isEmpty()){
            throw new DomainException("Categorie mag niet leeg zijn");
        }
        this.categorie = categorie;
    }
    public String getCategorie(){
        return this.categorie;
    }
    public Eten(){
    }

    public void setNaam(String naam) {
        if (naam.trim().isEmpty()){
            throw new DomainException("Naam mag niet leeg zijn");
        }
        this.naam = naam;
    }

    public String getNaam() {
        return this.naam;
    }

    public void setPrijs(double prijs) {
        if (prijs < 0 || prijs > 20){
            throw new DomainException("Prijs moet meer dan 0 en minder dan 20 euro zijn");
        }
        this.prijs = prijs;
    }

    public double getPrijs() {
        return this.prijs;
    }

    public void setExtrainfo(String extrainfo) {
        /*if (extrainfo.trim().isEmpty()) {
            throw new DomainException("Extra info mag niet leeg zijn");
        }*/
        this.extrainfo = extrainfo;
    }

    public String getExtrainfo() {
        return this.extrainfo;
    }
}
