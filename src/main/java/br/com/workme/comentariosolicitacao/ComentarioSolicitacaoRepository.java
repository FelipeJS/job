package br.com.workme.comentariosolicitacao;

import org.springframework.data.repository.CrudRepository;

import br.com.workme.solicitacao.Solicitacao;

public interface ComentarioSolicitacaoRepository extends CrudRepository<ComentarioSolicitacao, Long> {
	public Iterable<ComentarioSolicitacao> findBySolicitacao(Solicitacao solicitacao);
}