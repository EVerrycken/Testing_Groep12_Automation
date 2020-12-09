package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToAdJsp extends RequestHandler{
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "add.jsp";
    }
}
