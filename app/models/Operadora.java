package models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.db.jpa.GenericModel;

@Entity
@Table(name="operadora")
public class Operadora extends GenericModel{

	public Operadora() {
		
	}
	
	@Id
	@Column(name="id_operadora")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seqOperadora")
	@SequenceGenerator(name="seqOperadora", sequenceName="auto_increment_operadora")
	public Integer idOperadora;
	
	@Column(name="nome")
	public String nome;
	
	@Column(name="codigo")
	public int codigo;
	
	@Column(name="categoria")
	public String categoria;
	
	@Column(name="preco")
	public int preco;
	
	//@OneToMany(mappedBy="operadora", fetch=FetchType.LAZY)
	//public List<Contato> contatos;
	
	
	public static List<Operadora> findOperadoras(){
		return Operadora.findAll();
	}
	
	
	
	
	
	
	
}
