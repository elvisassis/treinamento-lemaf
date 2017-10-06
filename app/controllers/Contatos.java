package controllers;

import java.util.Date;

import javax.persistence.EntityManager;

import models.Contato;
import play.*;
import play.i18n.Messages;
import play.mvc.*;
import java.util.*;



public class Contatos extends DefautController {

    public static void index(int id) {
    	if (id == 1)
    		renderJSON(new Date());
    	else {
    		renderTemplate("errors/500.html");
    		
    	}
    }
    	
    public static void contatos() {
    	renderJSON(Contato.findContatos());
    	
    }
    
    public static void getContato(Integer id) {
    	renderJSON(Contato.findById(id));
    }
    
    public static void save(String body){
    	Contato.save(body);
    }
	
    public static void delete(Integer body) {
    	Contato.remover(body);
    }
    
    public static void edit(String body) {
    	//System.out.println(body);
    	Contato.editar(body);
    }

}
