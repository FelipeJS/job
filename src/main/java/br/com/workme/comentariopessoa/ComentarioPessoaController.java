package br.com.workme.comentariopessoa;

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

	@RequestMapping(value = "/salvar", method = GET)
	public ComentarioPessoa salvar(@RequestParam Long userIdComentado, @RequestParam String descricao) {
		ComentarioPessoa comentarioPessoa = new ComentarioPessoa();
		comentarioPessoa.setDescricao(descricao);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		comentarioPessoa.setUser(user);

		User userComentado = userService.findUserById(userIdComentado);
		comentarioPessoa.setUserComentado(userComentado);

		return comentarioPessoaRepository.save(comentarioPessoa);
	}
}