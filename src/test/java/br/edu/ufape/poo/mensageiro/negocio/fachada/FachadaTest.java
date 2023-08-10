package br.edu.ufape.poo.mensageiro.negocio.fachada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.mensageiro.negocio.basica.Grupo;
import br.edu.ufape.poo.mensageiro.negocio.basica.Usuario;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioNaoExisteException;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FachadaTest {
	@Autowired
	private Fachada fachada;
	
	@BeforeEach
	public void init() throws UsuarioDuplicadoException {
		Usuario u = new Usuario("Igor", "igor@gmail.com", "9875689");
		Usuario u2 = new Usuario("Medeiros", "medeiros@gmail.com", "9875689");
		Grupo g = new Grupo("POO", u);
		
		fachada.salvarUsuario(u);
		fachada.salvarUsuario(u2);
		fachada.salvarGrupo(g);		
	}
	
	@Test
	void testeAdicionarUsuarioGrupo() throws UsuarioNaoExisteException, UsuarioDuplicadoException {
		Grupo g = fachada.localizarGrupoId(1).get();
		int size = g.getMembros().size();
		fachada.adicionarUsuarioGrupo(1, "medeiros@gmail.com");
		g = fachada.localizarGrupoId(1).get();
		int size2 = g.getMembros().size();
		assertEquals(size + 1 , size2);
	}

}
