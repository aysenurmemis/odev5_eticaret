package �dev5.business.abstracts;

import java.util.List;

import �dev5.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
	List<User> getAll();

}
