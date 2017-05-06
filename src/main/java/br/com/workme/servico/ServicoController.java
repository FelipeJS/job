package br.com.workme.servico;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/salvar", method = POST)
	public Servico salvar(@RequestBody Servico servico) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		servico.setUser(userService.findUserByEmail(auth.getName()));
		return servicoRepository.save(servico);
	}

	@RequestMapping(value = "/excluir", method = GET)
	public Long excluir(@RequestParam Long cdServico) {
		Servico servico = servicoRepository.findOneByCdServico(cdServico);
		servicoRepository.delete(servico);
		return servico.getCdServico();
	}

	@RequestMapping("/listar")
	public Iterable<Servico> listar() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return servicoRepository.findByUser(user);
	}

	@RequestMapping(value = "/listarPorUsuario", method = GET)
	public Iterable<Servico> listarByUser(@RequestParam Long userId) {
		User user = userService.findUserById(userId);
		return servicoRepository.findByUser(user);
	}
}