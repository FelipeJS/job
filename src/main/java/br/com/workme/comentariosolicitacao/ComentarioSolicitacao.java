package br.com.workme.comentariosolicitacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.workme.solicitacao.Solicitacao;

@Entity
public class ComentarioSolicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_comentario_solicitacao")
	private Long cdComentarioSolicitacao;

	@ManyToOne
	@JoinColumn(name = "cd_solicitacao", referencedColumnName = "cd_solicitacao")
	private Solicitacao solicitacao;

	private String descricao;

	public Long getCdComentarioSolicitacao() {
		return cdComentarioSolicitacao;
	}

	public void setCdComentarioSolicitacao(Long cdComentarioSolicitacao) {
		this.cdComentarioSolicitacao = cdComentarioSolicitacao;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
