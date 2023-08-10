package br.edu.ufape.poo.mensageiro.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.mensageiro.dados.InterfaceColecaoMensagem;
import br.edu.ufape.poo.mensageiro.negocio.basica.Mensagem;
import br.edu.ufape.poo.mensageiro.negocio.basica.MensagemPrivada;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.AutoMensagemException;

@Service
public class CadastroMensagem implements InterfaceCadastroMensagem {
	@Autowired
	private InterfaceColecaoMensagem colecaoMensagem;

	public List<Mensagem> listarMensagensRemente(Long id) {
		return colecaoMensagem.findByRemetente_id(id);
	}

	public Mensagem salvarMensagem(Mensagem entity) throws AutoMensagemException{
		if(entity instanceof MensagemPrivada) {
			MensagemPrivada msg = (MensagemPrivada) entity;
			if(msg.getDestinatario().getId() == msg.getRemetente().getId())
				throw new AutoMensagemException(msg.getRemetente().getId());
		}
		return colecaoMensagem.save(entity);
	}

	public List<Mensagem> listarTodasMensagens() {
		return colecaoMensagem.findAll();
	}

	public void apagarMensagem(Mensagem entity) {
		colecaoMensagem.delete(entity);
	}
	
	

}
