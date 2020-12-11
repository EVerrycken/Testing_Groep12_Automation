package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveAll extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.getEtenDb().removeAll();
        return "index.jsp";
    }
}
