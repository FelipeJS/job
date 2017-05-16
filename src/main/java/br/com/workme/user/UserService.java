package br.com.workme.user;

import java.util.ArrayList;

public interface UserService {
	public User findUserByEmail(String email);

	public User findUserById(Long id);

	public Iterable<User> findByTipo(int tipo);

	public void saveUser(User user);

	public Iterable<User> findAllById(ArrayList<Long> ids);
}