package controllers;

import models.Operadora;
import play.mvc.*;

public class Operadoras extends DefautoController {

    public static void operadoras() {
        renderJSON(Operadora.getOperadoras());
    }

}
