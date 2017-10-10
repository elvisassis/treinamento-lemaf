package controllers;

import java.util.Date;

import models.Contato;



public class Contatos extends DefautController {

	
    public static void index(int id) {
    	if (id == 1)
    		renderJSON(new Date());
    	else {
    		renderTemplate("errors/500.html");
    		
    	}
    }
    
    
    public static void contatos() {
    	Contato contato = new Contato();
    	renderJSON(contato.findContatos());
    	
    }
    
    public static void getContato(Integer id) {
    	renderJSON(Contato.findById(id));
    }
    
    public static void save(String body){
    	Contato contato = new Contato();
    	contato.save(body);
    }
	
    public static void delete(Integer body) {
    	Contato contato = new Contato();
    	contato.remover(body);
    }
    

    public static void edit(String body) {
    	Contato contato = new Contato();
    	contato.editar(body);
    }

}
