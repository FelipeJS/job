package br.com.workme.configuracao;

import org.springframework.data.repository.CrudRepository;

import br.com.workme.user.User;

public interface ConfiguracaoRepository extends CrudRepository<Configuracao, Long> {
	public Configuracao findOneByUser(User user);
}
