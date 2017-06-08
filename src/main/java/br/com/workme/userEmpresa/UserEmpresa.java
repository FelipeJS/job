package br.com.workme.userEmpresa;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.workme.user.User;

@Entity
public class UserEmpresa implements Serializable {

	private static final long serialVersionUID = 5838483463123088299L;

	@Id
	@ManyToOne
	private User usuarioVisualiza;

	@Id
	@ManyToOne
	private User empresa;

	public UserEmpresa() {
	}

	public UserEmpresa(User usuarioVisualiza, User empresa) {
		super();
		this.usuarioVisualiza = usuarioVisualiza;
		this.empresa = empresa;
	}

	public User getUsuarioVisualiza() {
		return usuarioVisualiza;
	}

	public void setUsuarioVisualiza(User usuarioVisualiza) {
		this.usuarioVisualiza = usuarioVisualiza;
	}

	public User getEmpresa() {
		return empresa;
	}

	public void setEmpresa(User empresa) {
		this.empresa = empresa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		UserEmpresa other = (UserEmpresa) obj;
		return Objects.equals(usuarioVisualiza, other.usuarioVisualiza) && Objects.equals(empresa, other.empresa);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioVisualiza, empresa);
	}
}