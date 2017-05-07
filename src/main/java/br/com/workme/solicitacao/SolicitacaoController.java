package br.com.workme.solicitacao;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

	private static final int ABERTO = 1;
	private static final int ANALISE = 2;
	private static final int FECHADO = 3;
	private static final int RECUSADO = 4;

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/salvar", method = POST)
	public Solicitacao salvar(@RequestBody Solicitacao solicitacao) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		solicitacao.setUser(user);
		solicitacao.setDhSolicitacao(Calendar.getInstance().getTime());
		solicitacao.setStatus(ABERTO);

		return solicitacaoRepository.save(solicitacao);
	}

	@RequestMapping(value = "/aceitar", method = POST)
	public Solicitacao aceitar(@RequestBody Solicitacao solicitacao) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		solicitacao.setUserAnalise(user);
		solicitacao.setStatus(ANALISE);

		return solicitacaoRepository.save(solicitacao);
	}

	@RequestMapping(value = "/finalizar", method = POST)
	public Solicitacao finalizar(@RequestBody Solicitacao solicitacao) {
		solicitacao.setStatus(FECHADO);

		return solicitacaoRepository.save(solicitacao);
	}

	@RequestMapping(value = "/recusar", method = POST)
	public Solicitacao recusar(@RequestBody Solicitacao solicitacao) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		solicitacao.setUserAnalise(user);
		solicitacao.setStatus(RECUSADO);

		return solicitacaoRepository.save(solicitacao);
	}

	@RequestMapping("/listar")
	public Iterable<Solicitacao> listar() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		return solicitacaoRepository.findByUserId(user.getId());
	}
}