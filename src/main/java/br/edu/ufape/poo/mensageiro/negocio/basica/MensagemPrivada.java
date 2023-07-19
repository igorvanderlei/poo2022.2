package br.edu.ufape.poo.mensageiro.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class MensagemPrivada extends Mensagem{
	@ManyToOne
	private Usuario destinatario;

	public Usuario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	
	
}
