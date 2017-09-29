package controllers;

import java.util.Date;

import models.Contato;
import play.*;
import play.i18n.Messages;
import play.mvc.*;
import java.util.*;



public class Contatos extends DefautoController {

    public static void index(int id) {
    	if (id == 1)
    		renderJSON(new Date());
    	else {
    		renderTemplate("errors/500.html");
    		
    	}
    }
    	
    public static void contatos() {
    	renderJSON(Contato.getContatos());
    	
    }
    
    public static void save(String body){
    	Contato.saveContato(body);
 
    }
	

}
