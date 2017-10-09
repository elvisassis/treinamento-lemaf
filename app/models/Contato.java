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
	@Column(name="id_contato")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqContato")
	@SequenceGenerator(name="seqContato", sequenceName="auto_increment_contato")
	public Integer idContato;
	
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
	
	public static void save(String contatos) {
		Gson gson = new Gson();
		Contato contato = gson.fromJson(contatos, Contato.class);
		//Contato.em().persist(contato);
		contato.save();
	}
	
	
	public static void remover(Integer idContato) {
		play.Logger.info("Id contato "+idContato);
		Contato contato = Contato.find("idContato = ?", idContato).first();
		//Contato contato = Contato.em().getReference(Contato.class, idContato);
    	contato.delete();
	}
	
	public static void editar(String contatos) {
		Gson gson = new Gson();
		Contato contato = gson.fromJson(contatos, Contato.class);
		Contato contatoAtualizado = contato.merge();
		contatoAtualizado.save();

		
	}
	
	public static List<Contato> getContatosOperadoras(Operadora operadora){
		Query query = Contato.em().createQuery("select c from Contato c where c.operadora = :operadora");
		query.setParameter("operadora", operadora);
		return query.getResultList();
	}

	

	
	

	
}
