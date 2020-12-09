package ui.controller;

import domain.db.EtenDb;
import domain.model.Eten;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet("Controller")
public class Controller extends javax.servlet.http.HttpServlet {
    HandlerFactory handlerFactory = new HandlerFactory();
    EtenDb etenDb = new EtenDb();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        if (command != null){
            RequestHandler handler = handlerFactory.getHandler(command, etenDb);
            destination = handler.handleRequest(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}
