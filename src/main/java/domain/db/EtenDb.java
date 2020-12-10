package domain.db;

import domain.model.Eten;
import java.util.ArrayList;

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
        for (Eten e:eten) {
            if(e.getNaam().equals(naam)){
                eten.remove(e);
            }
        }
    }

    public ArrayList<Eten> getEten(){
        return eten;
    }
}
