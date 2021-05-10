package ödev5.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ödev5.business.abstracts.UserService;
import ödev5.core.MailCheck;
import ödev5.core.VerificationService;
import ödev5.dataAccess.abstracts.UserDao;
import ödev5.entities.concretes.User;

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
			System.out.println(user.getId()+" Kullanýcý en az iki harften az olmamalýdýr.");
			return;
		}
		
		if(user.getPassword().length() < 6) {
			System.out.println(user.getId()+" Þifre en az 6 arften oluþturulmalýdýr.");
			return;
		}
		
		if (!MailCheck.isEmailValid(user.getMail())) {
			System.out.println(user.getId()+" Geçerli bir mail adresi giriniz.");
		}
		
		if(userDao.getMail(user.getMail()) != null) {
			System.out.println(user.getId()+" Bu mail kullanýlmaktadýr.");
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
				System.out.println(user.getMail()+" email giriþi baþarýlýdýr.");
				return;
			}
			else {
				System.out.println(user.getMail()+" email giriþ baþarýsýz");
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
