package br.com.workme.curtida;

import org.springframework.data.repository.CrudRepository;

import br.com.workme.user.User;

public interface CurtidaRepository extends CrudRepository<Curtida, Long> {
	public Curtida findByUserAndUserCurtido(User user, User userCurtido);

	public Long countByUserCurtido(User userCurtido);
}
