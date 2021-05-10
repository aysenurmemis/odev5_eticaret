package �dev5.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import �dev5.business.abstracts.UserService;
import �dev5.core.MailCheck;
import �dev5.core.VerificationService;
import �dev5.dataAccess.abstracts.UserDao;
import �dev5.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private VerificationService veriService;
	
	public UserManager(UserDao userDao, VerificationService veriService) {
		this.userDao = userDao;
		this.veriService = veriService;
	}
	
	@Override
	public void register(User user) {

		if(user.getFirstName().length() < 2 && user.getLastName().length() < 2) {
			System.out.println(user.getId()+" Kullan�c� en az iki harften az olmamal�d�r.");
			return;
		}
		
		if(user.getPassword().length() < 6) {
			System.out.println(user.getId()+" �ifre en az 6 arften olu�turulmal�d�r.");
			return;
		}
		
		if (!MailCheck.isEmailValid(user.getMail())) {
			System.out.println(user.getId()+" Ge�erli bir mail adresi giriniz.");
		}
		
		if(userDao.getMail(user.getMail()) != null) {
			System.out.println(user.getId()+" Bu mail kullan�lmaktad�r.");
			return;
		}
		
		this.userDao.add(user);
		this.veriService.registerToGoogle(user.getMail());
	}

	@Override
	public void login(User user) {
		ArrayList<User> users = (ArrayList<User>) userDao.getAll();
		for (User user1 : users) {
			if(user.getMail()==user1.getMail()) {
				System.out.println(user.getMail()+" email giri�i ba�ar�l�d�r.");
				return;
			}
			else {
				System.out.println(user.getMail()+" email giri� ba�ar�s�z");
				return;
			}
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
