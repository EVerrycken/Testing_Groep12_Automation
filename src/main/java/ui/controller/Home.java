package ui.controller;

import domain.model.Eten;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Home extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Eten> etens = this.getEtenDb().getAllEten();
        request.setAttribute("eten", etens);
        return "index.jsp";
    }
}