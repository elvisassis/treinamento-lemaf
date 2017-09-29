package models;
import play.*;
import play.db.jpa.GenericModel;
import play.i18n.Messages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import com.google.gson.Gson;

@Entity
@Table(name="contato")
public class Contato extends GenericModel
{
	
	public Contato() {
		
	} 
	
	@Id
	@GeneratedValue
	public Integer id;
	
	public String telefone;
	public String data;
	public Operadora operadora;
	public String nome; 
	public String serial;
	
	  
	
	 
	 
	public static Contato[] getContatos() {
		Gson gson = new Gson();
		try { 
			BufferedReader br = new BufferedReader(new FileReader("db/contato.json"));	
			return gson.fromJson(br, Contato[].class);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	} 
	 
	public static void saveContato(String contato) {
		//Gson gson = new Gson();
		//String json = gson.toJson(contato);
		String msg="";
		try {
	 		FileWriter writer = new FileWriter("db/contato.json");
			writer.write(contato);
			msg = Messages.get("contato.salvar.sucesso");
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
		

	
}
