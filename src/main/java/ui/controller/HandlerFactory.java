package ui.controller;

import domain.db.EtenDb;

public class HandlerFactory {
    public RequestHandler getHandler(String handlerName, EtenDb etenDb) {
        RequestHandler handler;
        try {
            Class handlerClass = Class.forName("ui.controller." + handlerName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(etenDb);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet");
        }
        return handler;
    }
}
