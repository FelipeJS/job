package br.com.workme.curte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.workme.user.User;

@Entity
public class Curte {

	@Id
	@Column(name = "cd_curte")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cdCurte;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "user_id_curtido", referencedColumnName = "user_id")
	private User userCurtido;

	private Boolean curtiu;

	public Long getCdCurte() {
		return cdCurte;
	}

	public void setCdCurte(Long cdCurte) {
		this.cdCurte = cdCurte;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserCurtido() {
		return userCurtido;
	}

	public void setUserCurtido(User userCurtido) {
		this.userCurtido = userCurtido;
	}

	public Boolean getCurtiu() {
		return curtiu;
	}

	public void setCurtiu(Boolean curtiu) {
		this.curtiu = curtiu;
	}

}
