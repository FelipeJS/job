package br.com.workme.comentariosolicitacao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.solicitacao.Solicitacao;
import br.com.workme.solicitacao.SolicitacaoRepository;
import br.com.workme.user.User;
import br.com.workme.user.UserService;

@CrossOrigin
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

	@RequestMapping(value = "/salvar", method = POST)
	public ComentarioSolicitacao salvar(@RequestBody ComentarioSolicitacao comentarioSolicitacao) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		comentarioSolicitacao.setUser(user);

		return comentarioSolicitacaoRepository.save(comentarioSolicitacao);
	}
}
