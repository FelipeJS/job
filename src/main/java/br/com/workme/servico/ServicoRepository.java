package br.com.workme.servico;

import org.springframework.data.repository.CrudRepository;

import br.com.workme.user.User;

public interface ServicoRepository extends CrudRepository<Servico, Long> {
	public Iterable<Servico> findByUserAndAtivo(User user, int ativo);

	public Servico findOneByCdServico(Long cdServico);
}
