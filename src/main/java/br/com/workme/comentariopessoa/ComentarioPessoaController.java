package br.com.workme.comentariopessoa;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workme.user.User;
import br.com.workme.user.UserService;

@CrossOrigin
@RestController
@RequestMapping("/comentarioPessoa")
public class ComentarioPessoaController {

	@Autowired
	private ComentarioPessoaRepository comentarioPessoaRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/listar", method = GET)
	public Iterable<ComentarioPessoa> listar(@RequestParam Long userId) {
		User user = userService.findUserById(userId);

		return comentarioPessoaRepository.findByUserComentado(user);
	}
}
