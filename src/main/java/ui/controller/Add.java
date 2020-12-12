package ui.controller;

import domain.db.DbException;
import domain.model.DomainException;
import domain.model.Eten;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Add extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Eten eten = new Eten();
        List<String> errors = new ArrayList<>();
        setEtenNaam(eten,request,errors);
        setEtenPrijs(eten,request,errors);
        setEtenCategorie(eten, request, errors);
        setExtrainfo(eten,request,errors);
        setVegetarisch(eten, request, errors);
        if (errors.size() == 0) {
            try {
                etenDb.addEten(eten);
                return "Controller?command=Home";
            } catch (DbException e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors",errors);
        return "Controller?command=ToAddJsp";
    }

    private void setVegetarisch(Eten eten, HttpServletRequest request, List<String> errors) {
        String vegetarisch = request.getParameter("vegetarisch");
        if (vegetarisch != null){
            eten.setVegetarisch(true);
        }
        else{
            eten.setVegetarisch(false);
        }
    }

    private void setEtenCategorie(Eten eten, HttpServletRequest request, List<String> errors) {
        String categorie = request.getParameter("categorie");
        System.out.println(categorie);
        try{
            eten.setCategorie(categorie);
        }
        catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void setEtenNaam(Eten eten, HttpServletRequest request, List<String> errors) {
        String naam = request.getParameter("naam");
        try{
            eten.setNaam(naam);
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    public void setEtenPrijs(Eten eten, HttpServletRequest request, List<String> errors){
        try{
            if(request.getParameter("prijs").trim().isEmpty()){
                errors.add("Vul een prijs in");
            }else{
                double prijs = Double.parseDouble(request.getParameter("prijs"));
                eten.setPrijs(prijs);
            }
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    public void setExtrainfo(Eten eten, HttpServletRequest request, List<String> errors){
        String extraInfo = request.getParameter("extrainfo");
        if (extraInfo != null) {
            try{
                eten.setExtrainfo(extraInfo);
            }catch (DomainException e){
                errors.add(e.getMessage());
            }
        }
    }
}

