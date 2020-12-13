package ui.controller;

import domain.db.DbException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Remove extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("remove") == null){
            return "remove.jsp";
        }
        String naam = request.getParameter("naam");
        List<String> errors = new ArrayList<>();
        if (naam != null) {
            try {
                etenDb.removeEten(naam);
                return "Controller?command=Home";
            } catch (DbException e) {
                errors.add(e.getMessage());
            }
        }
        return "Controller?command=ToRemoveJsp";
    }
}
