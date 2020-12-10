package ui.controller;

import domain.db.EtenDb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    protected EtenDb etenDb;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;

    public void setModel (EtenDb etenDb) {
        this.etenDb = etenDb;
    }

    public EtenDb getEtenDb() {
        return etenDb;
    }
}
