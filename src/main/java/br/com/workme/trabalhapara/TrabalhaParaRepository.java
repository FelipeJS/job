package br.com.workme.trabalhapara;

import org.springframework.data.repository.CrudRepository;

import br.com.workme.user.User;

public interface TrabalhaParaRepository extends CrudRepository<TrabalhaPara, Long> {
	public Iterable<TrabalhaPara> findByUserFuncionario(User userFuncionario);

	public TrabalhaPara findOneByUserFuncionarioAndUserEmpresa(User userFuncionario, User userEmpresa);

	public Iterable<TrabalhaPara> findByUserEmpresa(User userEmpresa);
}