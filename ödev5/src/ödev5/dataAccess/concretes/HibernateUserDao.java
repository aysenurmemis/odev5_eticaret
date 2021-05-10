package ödev5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ödev5.dataAccess.abstracts.UserDao;
import ödev5.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	ArrayList<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
	}


	@Override
	public ArrayList<User> getAll() {
		return users;
	}

	@Override
	public User getMail(String mail) {
		for(User user : users) {
			if(user.getMail().equals(mail)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getPassword(String password) {
		for(User user : users) {
			if(user.getMail().equals(password));
			return user;
		}
		return null;
	}

	@Override
	public User login(String mail, String password) {
		for(User user : users) {
			if(user.getMail().equals(mail) && user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}

}
