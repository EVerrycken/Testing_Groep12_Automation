package ui.controller;


import domain.db.EtenDb;

public class HandlerFactory {

    public HandlerFactory(){
    }

    public RequestHandler getHandler(String handlerName, EtenDb db) {
        RequestHandler handler = null;
        try{
            Class handlerClass = Class.forName("ui.controller."+ handlerName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(db);
        }catch (Exception e) {
            throw new RuntimeException("Onbekende Pagina");
        }
        return handler;
    }
}
