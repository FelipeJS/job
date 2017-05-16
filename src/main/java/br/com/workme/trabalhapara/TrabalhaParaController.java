package br.com.workme.trabalhapara;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@RestController
@RequestMapping("/trabalhaPara")
public class TrabalhaParaController {

	@Autowired
	private TrabalhaParaRepository trabalhaParaRepository;

	@Autowired
	private UserService userService;

	public User getUsuarioLogado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findUserByEmail(auth.getName());
	}

	@RequestMapping("/listar")
	public Iterable<TrabalhaPara> listar() {
		return trabalhaParaRepository.findByUserFuncionario(getUsuarioLogado());
	}

	@RequestMapping(value = "/salvar", method = GET)
	public TrabalhaPara salvar(@RequestParam Long cdUsuarioFuncionario) {
		TrabalhaPara trabalhaPara = new TrabalhaPara();

		trabalhaPara.setUserEmpresa(getUsuarioLogado());
		trabalhaPara.setUserFuncionario(userService.findUserById(cdUsuarioFuncionario));
		return trabalhaParaRepository.save(trabalhaPara);
	}

	@RequestMapping(value = "/excluir", method = GET)
	public Long excluir(@RequestParam Long cdUsuarioFuncionario) {
		User userFuncionario = userService.findUserById(cdUsuarioFuncionario);
		User userEmpresa = getUsuarioLogado();

		TrabalhaPara trabalhaPara = trabalhaParaRepository.findOneByUserFuncionarioAndUserEmpresa(userFuncionario,
				userEmpresa);

		trabalhaParaRepository.delete(trabalhaPara);
		return trabalhaPara.getCdTrabalhaPara();
	}
}