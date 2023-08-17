package br.edu.ufape.poo.mensageiro.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.mensageiro.negocio.basica.Usuario;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.mensageiro.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	@Autowired
	public Fachada fachada;
	
	@GetMapping("/usuario")
	public List<Usuario> listarUsuario() {
		return fachada.listarUsuarios();
	}
	
	@PostMapping("/usuario")
	public Usuario cadastrarUsuario(@RequestBody Usuario u) 
			throws UsuarioDuplicadoException {
			return fachada.salvarUsuario(u);
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario exibirUsuario(@PathVariable long id) {
		return fachada.localizarUsuarioId(id);
	}
	
	
	@PatchMapping("/usuario/{id}")
	public Usuario atualizarDados(@PathVariable long id, @RequestBody Usuario u) throws UsuarioDuplicadoException {
		u.setId(id);
		return fachada.salvarUsuario(u);
	}
	
	@DeleteMapping("/usuario/{email}")
	public String apagarUsuario(@PathVariable String email) 
			throws UsuarioNaoExisteException {
		
		 fachada.removerUsuarioEmail(email);
		 return "ok";
	}
	
}
