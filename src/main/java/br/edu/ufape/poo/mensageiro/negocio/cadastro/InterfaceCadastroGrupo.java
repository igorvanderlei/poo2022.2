package br.edu.ufape.poo.mensageiro.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.mensageiro.negocio.basica.Grupo;

public interface InterfaceCadastroGrupo {

	List<Grupo> procurarGrupoNome(String nome);

	Grupo salvarGrupo(Grupo entity);

	List<Grupo> listarGrupos();

	void removerGrupo(Long id);

	void removerGrupo(Grupo entity);

	Optional<Grupo> localizarGrupoId(long id);

}