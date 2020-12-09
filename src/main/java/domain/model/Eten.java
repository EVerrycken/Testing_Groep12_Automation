package domain.model;

public class Eten {
    public String naam;
    public int Prijs;
    public String extrainfo;

    public Eten(String naam, int prijs, String extrainfo){
        setNaam(naam);
        setPrijs(prijs);
        setExtrainfo(extrainfo);
    }

    public Eten(){
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(int prijs) {
        if(prijs < 0 || prijs > 20){
            throw new IllegalArgumentException("prijs moet meer dan 0 en minder dan 20 euro zijn");
        }
        Prijs = prijs;
    }

    public String getNaam() {
        if(naam.trim().isEmpty()){
            throw new IllegalArgumentException("naam mag niet leeg zijn");
        }
        return naam;
    }

    public void setExtrainfo(String extrainfo) {
        this.extrainfo = extrainfo;
    }

    public String getExtrainfo() {
        return extrainfo;
    }

    public int getPrijs() {
        return Prijs;
    }
}
