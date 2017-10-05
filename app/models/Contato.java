package models;
import play.*;
import play.db.jpa.GenericModel;
import play.db.jpa.JPABase;
import play.i18n.Messages;
import play.mvc.Http.Response;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.google.gson.Gson;

@Entity
@Table(name="contato")
public class Contato extends GenericModel
{
	
	public Contato() {
		
	} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqContato")
	@SequenceGenerator(name="seqContato", sequenceName="auto_increment_contato")
	public Integer id_contato;
	
	@Column(name="telefone")
	public String telefone;
	
	@Column(name="data") 
	public String data;
	
	@ManyToOne
	@JoinColumn(name="operadora_id_operadora")
	public Operadora operadora;
	
	@Column(name="nome")
	public String nome; 
	
	@Column(name="serial")
	public String serial;
	

	public static List<Contato> findContatos() {
		return Contato.findAll();	
		//return Contato.em().createQuery("from Contato").getResultList();

	}
	
	public static void save(String contato) {
		Gson gson = new Gson();
		Contato cont = gson.fromJson(contato, Contato.class);
		//Contato.em().persist(cont);
		cont.save();
	}
	
	
	
		

	

	
	

	
}
