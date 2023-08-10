package br.edu.ufape.poo.mensageiro.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.mensageiro.dados.InterfaceColecaoUsuario;
import br.edu.ufape.poo.mensageiro.negocio.basica.Usuario;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioNaoExisteException;

@Service
public class CadastroUsuario implements InterfaceCadastroUsuario {
	@Autowired
	private InterfaceColecaoUsuario colecaoUsuario;

	
	public Usuario procurarUsuarioEmail(String email) 
			throws UsuarioNaoExisteException {
		Usuario u = colecaoUsuario.findByEmail(email); 
		if(u == null) {
			throw new UsuarioNaoExisteException(email);
		}
		return u;
	}
	
	public Usuario salvarUsuario(Usuario entity)
				throws UsuarioDuplicadoException {
		try {
			procurarUsuarioEmail(entity.getEmail());
			throw new UsuarioDuplicadoException(entity.getEmail());
		} catch(UsuarioNaoExisteException err) {
			return colecaoUsuario.save(entity);
		}
	}

	public List<Usuario> listarUsuarios() {
		return colecaoUsuario.findAll();
	}

	public boolean verificarExistenciaUsuarioId(Long id) {
		return colecaoUsuario.existsById(id);
	}

	public Usuario localizarUsuarioId(Long id) {
		return colecaoUsuario.findById(id).orElse(null);
	}
	
	public void removerUsuarioEmail(String email) 
			throws UsuarioNaoExisteException {
		Usuario u = procurarUsuarioEmail(email);
		colecaoUsuario.delete(u);
	}
	
	
}
