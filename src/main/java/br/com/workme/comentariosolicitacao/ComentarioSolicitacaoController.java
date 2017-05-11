package br.com.workme.comentariosolicitacao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.solicitacao.Solicitacao;
import br.com.workme.solicitacao.SolicitacaoRepository;
import br.com.workme.user.User;
import br.com.workme.user.UserService;

@RestController
@RequestMapping("/comentarioSolicitacao")
public class ComentarioSolicitacaoController {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	@Autowired
	private ComentarioSolicitacaoRepository comentarioSolicitacaoRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/listar", method = GET)
	public Iterable<ComentarioSolicitacao> listar(@RequestParam Long cdSolicitacao) {
		Solicitacao solicitacao = solicitacaoRepository.findOneByCdSolicitacao(cdSolicitacao);
		return comentarioSolicitacaoRepository.findBySolicitacao(solicitacao);
	}

	@RequestMapping(value = "/salvar", method = GET)
	public ComentarioSolicitacao salvar(@RequestParam Long cdSolicitacao, @RequestParam String descricao) {
		Solicitacao solicitacao = solicitacaoRepository.findOneByCdSolicitacao(cdSolicitacao);

		ComentarioSolicitacao comentarioSolicitacao = new ComentarioSolicitacao();
		comentarioSolicitacao.setSolicitacao(solicitacao);
		comentarioSolicitacao.setDescricao(descricao);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		comentarioSolicitacao.setUser(user);

		return comentarioSolicitacaoRepository.save(comentarioSolicitacao);
	}
}