package controllers;

import models.Operadora;
import play.mvc.*;

public class Operadoras extends DefautController {

    public static void operadoras() {
    	Operadora operadora = new Operadora();
        renderJSON(operadora.findOperadoras());
    }

}
