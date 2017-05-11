package br.com.workme.comentariopessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.workme.user.User;

@Entity
public class ComentarioPessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_comentario_pessoa")
	private Long cdComentarioPessoa;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "user_id_comentado", referencedColumnName = "user_id")
	private User userComentado;

	private String descricao;

	public Long getCdComentarioPessoa() {
		return cdComentarioPessoa;
	}

	public void setCdComentarioPessoa(Long cdComentarioPessoa) {
		this.cdComentarioPessoa = cdComentarioPessoa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserComentado() {
		return userComentado;
	}

	public void setUserComentado(User userComentado) {
		this.userComentado = userComentado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}