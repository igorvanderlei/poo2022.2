package br.edu.ufape.poo.mensageiro.negocio.fachada;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.mensageiro.negocio.basica.Grupo;
import br.edu.ufape.poo.mensageiro.negocio.basica.Mensagem;
import br.edu.ufape.poo.mensageiro.negocio.basica.Usuario;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.InterfaceCadastroGrupo;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.InterfaceCadastroMensagem;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.InterfaceCadastroUsuario;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.AutoMensagemException;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioNaoExisteException;

@Service
public class Fachada {
	@Autowired
	private InterfaceCadastroUsuario cadastroUsuario;
	@Autowired
	private InterfaceCadastroGrupo cadastroGrupo;
	@Autowired
	private InterfaceCadastroMensagem cadastroMensagem;
	
	
	public Usuario procurarUsuarioEmail(String email) throws UsuarioNaoExisteException {
		return cadastroUsuario.procurarUsuarioEmail(email);
	}
	public Usuario salvarUsuario(Usuario entity) throws UsuarioDuplicadoException {
		return cadastroUsuario.salvarUsuario(entity);
	}
	public List<Usuario> listarUsuarios() {
		return cadastroUsuario.listarUsuarios();
	}
	public boolean verificarExistenciaUsuarioId(Long id) {
		return cadastroUsuario.verificarExistenciaUsuarioId(id);
	}
	public Usuario localizarUsuarioId(Long id) {
		return cadastroUsuario.localizarUsuarioId(id);
	}
	public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
		cadastroUsuario.removerUsuarioEmail(email);
	}
	public List<Grupo> procurarGrupoNome(String nome) {
		return cadastroGrupo.procurarGrupoNome(nome);
	}
	public Grupo salvarGrupo(Grupo entity) {
		return cadastroGrupo.salvarGrupo(entity);
	}
	public List<Grupo> listarGrupos() {
		return cadastroGrupo.listarGrupos();
	}
	public void removerGrupo(Long id) {
		cadastroGrupo.removerGrupo(id);
	}
	public void removerGrupo(Grupo entity) {
		cadastroGrupo.removerGrupo(entity);
	}

	public Optional<Grupo> localizarGrupoId(long id) {
		return cadastroGrupo.localizarGrupoId(id);
	}
	public void adicionarUsuarioGrupo(long idGrupo, String emailUsuario) 
			throws UsuarioNaoExisteException 
		 {
		Grupo grupo = localizarGrupoId(idGrupo).get();
		Usuario u = procurarUsuarioEmail(emailUsuario);
		
		grupo.adicionarMembro(u);
		salvarGrupo(grupo);
	}
	public List<Mensagem> listarMensagensRemente(Long id) {
		return cadastroMensagem.listarMensagensRemente(id);
	}
	public Mensagem salvarMensagem(Mensagem entity) throws AutoMensagemException {
		return cadastroMensagem.salvarMensagem(entity);
	}
	public List<Mensagem> listarTodasMensagens() {
		return cadastroMensagem.listarTodasMensagens();
	}
	public void apagarMensagem(Mensagem entity) {
		cadastroMensagem.apagarMensagem(entity);
	}
	
	
	
}
