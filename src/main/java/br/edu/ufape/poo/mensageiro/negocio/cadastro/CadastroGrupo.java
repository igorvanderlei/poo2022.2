package br.edu.ufape.poo.mensageiro.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.mensageiro.dados.InterfaceColecaoGrupo;
import br.edu.ufape.poo.mensageiro.negocio.basica.Grupo;

@Service
public class CadastroGrupo implements InterfaceCadastroGrupo {
	@Autowired
	private InterfaceColecaoGrupo colecaoGrupo;

	public List<Grupo> procurarGrupoNome(String nome) {
		return colecaoGrupo.findByNomeContainingIgnoreCase(nome);
	}

	public Grupo salvarGrupo(Grupo entity) {
		return colecaoGrupo.save(entity);
	}

	public List<Grupo> listarGrupos() {
		return colecaoGrupo.findAll();
	}

	public void removerGrupo(Long id) {
		colecaoGrupo.deleteById(id);
	}

	public void removerGrupo(Grupo entity) {
		colecaoGrupo.delete(entity);
	}
	
	public Optional<Grupo> localizarGrupoId(long id) {
		return colecaoGrupo.findById(id);
	}
	
	
}
