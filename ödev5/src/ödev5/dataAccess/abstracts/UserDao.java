package �dev5.dataAccess.abstracts;

import java.util.List;

import �dev5.entities.concretes.User;

public interface UserDao {
	void add(User user);
	User getMail(String mail);
	User getPassword(String password);
	User login(String mail,String password);
	List<User> getAll();
}
