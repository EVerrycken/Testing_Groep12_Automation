package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Remove extends RequestHandler{
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(request.getParameter("remove") != null){
            String naam = request.getParameter("naam");
            List<String> errors = new ArrayList<String>();
            if(naam != null){
                try{
                    etenDb.removeEten(naam);
                }catch (Exception e){
                    errors.add(e.getMessage());
                }
            }
            if(errors.size() > 0) request.setAttribute("errors", errors);
            return "index.jsp";
        }
        return "remove.jsp";
    }
}
