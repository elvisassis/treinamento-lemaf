package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import play.*;

public class Operadora {

	public Operadora() {
		
	}
	
	public String nome;
	public int codigo;
	public String categoria;
	public int preco;
	
	
	public static Operadora[] getOperadoras() {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader("db/operadoras.json"));
			return gson.fromJson(br, Operadora[].class);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	
	
}
