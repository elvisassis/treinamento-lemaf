package models;
import play.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Contato {
	
	public Contato() {
		
	} 
	
	private String telefone;
	private String data;
	private Operadora operadora;
	private String nome; 
	private String serial;
	
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	  
	 
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
		try {
	 		FileWriter writer = new FileWriter("db/contato.json");
			writer.write(contato);
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
		

	
}
