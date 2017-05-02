package br.com.workme.comentariosolicitacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.workme.solicitacao.Solicitacao;
import br.com.workme.user.User;

@Entity
public class ComentarioSolicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_comentario_solicitacao")
	private Long cdComentarioSolicitacao;

	@ManyToOne
	@JoinColumn(name = "cd_solicitacao", referencedColumnName = "cd_solicitacao")
	private Solicitacao solicitacao;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@Column(name = "descricao")
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}