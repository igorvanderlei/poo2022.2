package br.edu.ufape.poo.mensageiro.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.mensageiro.negocio.basica.Mensagem;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.AutoMensagemException;

public interface InterfaceCadastroMensagem {

	List<Mensagem> listarMensagensRemente(Long id);

	Mensagem salvarMensagem(Mensagem entity) throws AutoMensagemException;

	List<Mensagem> listarTodasMensagens();

	void apagarMensagem(Mensagem entity);

}