package �dev5;

import �dev5.business.concretes.UserManager;
import �dev5.core.GoogleVerificationAdapterManager;
import �dev5.dataAccess.abstracts.UserDao;
import �dev5.dataAccess.concretes.HibernateUserDao;
import �dev5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Ay�enur", "Memi�", "aysenurmms2@gmail.com", "134456");
		User user2 = new User(2, "sait", "�ivgin", "esin.yaygi@gmjail.com", "144356");

		
		UserManager userManager = new UserManager(new HibernateUserDao(), new GoogleVerificationAdapterManager());
			
			
		
		userManager.register(user1);
		userManager.register(user2);

		System.out.println("-----------------------");
		
		userManager.login(user1);
		userManager.login(user2);

	}

}
