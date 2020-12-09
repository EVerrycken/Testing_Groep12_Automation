package ui.controller;

import domain.db.EtenDb;
import domain.model.Eten;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Add extends RequestHandler{
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        int prijs = Integer.parseInt(request.getParameter("prijs"));
        String extra = request.getParameter("extra");
        Eten eten = new Eten();
        List<String> errors = new ArrayList<String>();
        setEtenNaam(naam, errors, eten);
        setEtenPrijs(prijs, errors, eten);
        if(extra != null) setExtrainfo(extra, errors, eten);
        addEtenToDb(eten, errors);
        if(errors.size() > 0){
            request.setAttribute("errors", errors);
        }
        return "index.jsp";
    }

    private void setExtrainfo(String extra, List<String> errors, Eten eten) {
        try{
            eten.setExtrainfo(extra);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    public void setEtenNaam(String naam, List<String> errors, Eten eten){
        try{
            eten.setNaam(naam);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    public void setEtenPrijs(int prijs, List<String> errors, Eten eten){
        try{
            eten.setPrijs(prijs);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    public void addEtenToDb(Eten eten, List<String> errors){
        try{
            etenDb.addEten(eten);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }
}
