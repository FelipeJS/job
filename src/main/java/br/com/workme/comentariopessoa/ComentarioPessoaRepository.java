package br.com.workme.comentariopessoa;

import br.com.workme.user.User;

public interface ComentarioPessoaRepository {
	public Iterable<ComentarioPessoa> findByUserComentado(User userComentado);
}
