package br.edu.ufape.poo.mensageiro.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class MensagemGrupo extends Mensagem {
	@ManyToOne
	private Grupo destinatario;

	public Grupo getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Grupo destinatario) {
		this.destinatario = destinatario;
	}
	
}
