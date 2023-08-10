package br.edu.ufape.poo.mensageiro.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.mensageiro.negocio.basica.Mensagem;
import br.edu.ufape.poo.mensageiro.negocio.basica.MensagemPrivada;
import br.edu.ufape.poo.mensageiro.negocio.basica.Usuario;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.AutoMensagemException;
import br.edu.ufape.poo.mensageiro.negocio.cadastro.exception.UsuarioDuplicadoException;

@SpringBootTest
class CadastroMensagemTest {
	@Autowired
	private InterfaceCadastroMensagem cadastroMensagem;

	@Test
	void testeAutoMensagem() {
		Usuario u1 = new Usuario("Igor", "igor@gmail.com", "12345678");
		u1.setId(1);
		MensagemPrivada m1 = new MensagemPrivada();
		m1.setRemetente(u1);
		m1.setDestinatario(u1);
		m1.setTexto("bla bla bla");
	
		AutoMensagemException exception = 
				assertThrows(AutoMensagemException.class, 
			() -> {
				cadastroMensagem.salvarMensagem(m1);
				  }			
		);
		
	}

}
