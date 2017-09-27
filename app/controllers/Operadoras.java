package controllers;

import models.Operadora;
import play.mvc.*;

public class Operadoras extends Controller {

    public static void operadoras() {
        renderJSON(Operadora.getOperadoras());
    }

}
