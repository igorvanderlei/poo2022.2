package br.edu.ufape.poo.mensageiro.negocio.basica;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	@ManyToOne
	private Usuario administrador;
	@ManyToMany
	private List<Usuario> membros;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}
	public List<Usuario> getMembros() {
		return membros;
	}
	public void setMembros(List<Usuario> membros) {
		this.membros = membros;
	}
	public Grupo() {
		super();
		this.membros = new ArrayList<Usuario>();
	}
	public Grupo(String nome, Usuario administrador) {
		this();
		this.nome = nome;
		this.administrador = administrador;
		adicionarMembro(administrador);
	}
	
	public void adicionarMembro(Usuario u) {
		membros.add(u);
	} 
	
	

}
