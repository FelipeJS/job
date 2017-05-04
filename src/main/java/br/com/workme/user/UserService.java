package br.com.workme.user;

public interface UserService {
	public User findUserByEmail(String email);

	public User findUserById(Long id);

	public Iterable<User> findByTipo(int tipo);

	public void saveUser(User user);

	public User update(User user);
}
