package domain.db;

import domain.model.Eten;
import java.util.ArrayList;
import java.util.Collection;

public class EtenDb {
    private ArrayList<Eten> eten = new ArrayList<>();

    public EtenDb(){
    }

    public void addEten(Eten e){
        if (e == null) {
            throw new DbException("Geen eten gegeven");
        }
        eten.add(e);
    }

    public void removeEten(String naam){
        if (naam.trim().isEmpty()) {
            throw new DbException("Geen naam gegeven");
        }
        eten.removeIf(e->e.getNaam().equals(naam));
    }
    public void removeAll(){
        eten.removeAll(eten);
    }
    public Eten getEten(String naam){
        for (Eten e : eten){
            if (e.getNaam().equals(naam.toLowerCase())){
                return e;
            }
        }
        throw new DbException("Geen eten met gegeven naam gevonden");
    }

    public ArrayList<Eten> getAllEten(){
        return eten;
    }
}
