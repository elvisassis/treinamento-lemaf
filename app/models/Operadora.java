package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.Gson;

import play.*;
import play.db.jpa.GenericModel;

@Entity
@Table(name="operadora")
public class Operadora extends GenericModel{

	public Operadora() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqOperadora")
	@SequenceGenerator(name="seqOperadora", sequenceName="auto_increment_operadora")
	public Integer id_operadora;
	
	@Column(name="nome")
	public String nome;
	
	@Column(name="codigo")
	public int codigo;
	
	@Column(name="categoria")
	public String categoria;
	
	@Column(name="preco")
	public int preco;
	
	
	public static List<Operadora> findOperadoras(){
		return Operadora.findAll();
	}
	
	/*public static Operadora[] getOperadoras() {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader("db/operadoras.json"));
			return gson.fromJson(br, Operadora[].class);
		}catch (IOException e) {
			e.printStackTrace();
		}
			
		return null;
		
		
	}*/
	
	
	
	
	
	
}
