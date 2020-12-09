package domain.db;

import domain.model.Eten;

import java.util.ArrayList;

public class EtenDb {
    public ArrayList<Eten> eten = new ArrayList<>();

    public EtenDb(){
    }

    public void addEten(Eten e){
        eten.add(e);
    }

    public void removeEten(String naam){
        int x = 0;
        int y = -1;
        for (Eten e:eten) {
            if(e.getNaam().equals(naam)){
                y = x;
            }
            x++;
        }
        if(y >= 0){
            eten.remove(y);
        }
    }

}
