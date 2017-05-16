package br.com.workme.solicitacao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.servico.ServicoRepository;
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

	@Autowired
	private ServicoRepository servicoRepository;

	public User getUsuarioLogado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findUserByEmail(auth.getName());
	}

	@RequestMapping(value = "/salvar", method = GET)
	public Solicitacao salvar(@RequestParam String descricao, @RequestParam Long cdServico) {
		Solicitacao solicitacao = new Solicitacao();

		solicitacao.setDescricao(descricao);
		solicitacao.setServico(servicoRepository.findOneByCdServico(cdServico));
		solicitacao.setUser(getUsuarioLogado());
		solicitacao.setDhSolicitacao(new Date());
		solicitacao.setStatus(ABERTO);

		return solicitacaoRepository.save(solicitacao);
	}

	@RequestMapping(value = "/aceitar", method = POST)
	public Solicitacao aceitar(@RequestBody Solicitacao solicitacao) {
		solicitacao.setUserAnalise(getUsuarioLogado());
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
		solicitacao.setUserAnalise(getUsuarioLogado());
		solicitacao.setStatus(RECUSADO);

		return solicitacaoRepository.save(solicitacao);
	}

	@RequestMapping("/listarAbertos")
	public Iterable<Solicitacao> listarAbertos() {
		return solicitacaoRepository.findByUserIdAberto(getUsuarioLogado().getId());
	}

	@RequestMapping("/listarAnalisados")
	public Iterable<Solicitacao> listarAnalisados() {
		return solicitacaoRepository.findByUserIdAnalise(getUsuarioLogado().getId());
	}

	@RequestMapping("/listarFechados")
	public Iterable<Solicitacao> listarFechados() {
		return solicitacaoRepository.findByUserIdFechado(getUsuarioLogado().getId());
	}

	@RequestMapping("/listarMinhasSolicitacoes")
	public Iterable<Solicitacao> listarMinhasSolicitacoes() {
		return solicitacaoRepository.findByUser(getUsuarioLogado());
	}
}