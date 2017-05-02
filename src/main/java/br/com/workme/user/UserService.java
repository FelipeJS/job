package br.com.workme.user;

public interface UserService {
	public User findUserByEmail(String email);

	public User findUserById(Long id);

	public Iterable<User> findAll();

	public void saveUser(User user);
}
