package br.com.workme.userEmpresa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.workme.user.User;

public interface UserEmpresaRepository extends JpaRepository<UserEmpresa, Long> {
	public UserEmpresa findByUsuarioVisualizaAndEmpresa(User usuarioVisualiza, User empresa);
}