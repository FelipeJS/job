package br.com.workme.curtida;

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

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@CrossOrigin
@RestController
@RequestMapping("/curtida")
public class CurtidaController {

	@Autowired
	private CurtidaRepository curtidaRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/salvar", method = POST)
	public Curtida salvar(@RequestBody Curtida curtida) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		curtida.setUser(user);

		return curtidaRepository.save(curtida);
	}

	@RequestMapping(value = "/consultar", method = GET)
	public Long contar(@RequestParam Long userCurtidoId) {
		User userCurtido = userService.findUserById(userCurtidoId);
		return curtidaRepository.countByUserCurtido(userCurtido);
	}
}