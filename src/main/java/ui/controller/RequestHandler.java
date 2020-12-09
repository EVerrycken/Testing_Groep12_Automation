package ui.controller;

import domain.db.EtenDb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected EtenDb etenDb;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setModel(EtenDb service){
        etenDb = service;
    }

    public EtenDb geEtenDb(){
        return etenDb;
    }
}