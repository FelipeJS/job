package br.com.workme.solicitacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
	@Query(value = "SELECT S.*, V.nome, U.* FROM servico V INNER JOIN solicitacao S ON S.CD_SERVICO = V.CD_SERVICO "
			+ "INNER JOIN user U ON U.USER_ID = S.USER_ID "
			+ "WHERE V.USER_ID = ?1", nativeQuery = true)
	public Iterable<Solicitacao> findByUserId(Long userId);
	
	public Solicitacao findOneByCdSolicitacao(Long cdSolicitacao);
}
