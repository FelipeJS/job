package br.com.workme.trabalhapara;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.workme.user.User;

public interface TrabalhaParaRepository extends CrudRepository<TrabalhaPara, Long> {
	@Query(value = "SELECT U.* FROM trabalha_para T INNER JOIN user U ON U.USER_ID = T.USER_ID_FUNCIONARIO "
			+ "WHERE T.USER_ID = ?1", nativeQuery = true)
	public Iterable<User> findByUserId(Long userId);
}
