package br.edu.ufape.poo.mensageiro.dados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.mensageiro.negocio.basica.Endereco;
import br.edu.ufape.poo.mensageiro.negocio.basica.Usuario;

@SpringBootTest
class InterfaceColecaoUsuarioTest {
	@Autowired
	private InterfaceColecaoUsuario colecaoUsuario;

	@Test
	void cadastrarTest() {
		//Inicialização
		long qtdUsuario = colecaoUsuario.count();
		Usuario u = new Usuario("Igor", "igor@gmail.com", "12345678");
		Endereco e = new Endereco("rua a", "centro", "pe", "cep", "s/n");
		u.setEndereco(e);
		
		//Interação
		colecaoUsuario.save(u);
		long qtdUsuario2 = colecaoUsuario.count();
		
		//Verificação
		assertEquals(qtdUsuario + 1, qtdUsuario2);
	}
}
