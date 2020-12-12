package domain.model;

public class Eten {
    private String naam;
    private double prijs;
    private String extrainfo;
    private String categorie;
    private boolean vegetarsich;

    public Eten(String naam, double prijs, String extrainfo, String categorie, boolean vegetarsich){
        setNaam(naam);
        setPrijs(prijs);
        setExtrainfo(extrainfo);
        setCategorie(categorie);
        setVegetarisch(vegetarsich);
    }

    public Eten(){
    }

    public void setVegetarisch(boolean vegetarsich) {
        this.vegetarsich = vegetarsich;
    }

    public boolean isVegetarisch() {
        return vegetarsich;
    }

    public void setCategorie(String categorie) {
        if(categorie.trim().isEmpty()) throw new DomainException("Categorie moet ingevuld zijn");
        System.out.println(categorie);
        if(categorie.equals("broodje") || categorie.equals("pasta") || categorie.equals("soep")){
            this.categorie = categorie;
        }else{
            throw new DomainException("Vul een categorie in: broodje/pasta/soep");
        }
    }

    public String getCategorie() {
        return categorie;
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
        if (extrainfo.trim().isEmpty()) {
            throw new DomainException("Extra info mag niet leeg zijn");
        }
        this.extrainfo = extrainfo;
    }

    public String getExtrainfo() {
        return this.extrainfo;
    }
}
