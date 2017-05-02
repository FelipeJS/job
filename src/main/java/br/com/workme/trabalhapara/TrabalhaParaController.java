package br.com.workme.trabalhapara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@CrossOrigin
@RestController
@RequestMapping("/trabalhaPara")
public class TrabalhaParaController {

	@Autowired
	private TrabalhaParaRepository trabalhaParaRepository;

	@Autowired
	private UserService userService;

	@RequestMapping("/listar")
	public Iterable<User> listar() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		return trabalhaParaRepository.findByUserId(user.getId());
	}
}
