package br.com.workme.comentariopessoa;

import org.springframework.data.repository.CrudRepository;

import br.com.workme.user.User;

public interface ComentarioPessoaRepository extends CrudRepository<ComentarioPessoa, Long> {
	public Iterable<ComentarioPessoa> findByUserComentado(User userComentado);
}
