package br.com.workme.configuracao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {

	@Autowired
	private ConfiguracaoRepository configuracaoRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/consultar", method = GET)
	public Configuracao consultar() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return configuracaoRepository.findOneByUser(user);
	}

	@RequestMapping(value = "/salvar", method = POST)
	public Configuracao salvar(@RequestBody Configuracao configuracao) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		configuracao.setUser(user);
		return configuracaoRepository.save(configuracao);
	}
}