package br.edu.ufape.poo.mensageiro.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.mensageiro.negocio.basica.Grupo;

@Repository
public interface InterfaceColecaoGrupo 
	extends JpaRepository<Grupo, Long>{
	public List<Grupo> findByNomeContainingIgnoreCase(String nome);
	
}
