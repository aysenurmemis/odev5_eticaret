package �dev5.core;

import �dev5.GoogleAccount.GoogleManager;
import �dev5.dataAccess.abstracts.UserDao;

public class GoogleVerificationAdapterManager implements VerificationService{

	@Override
	public void registerToGoogle(String message) {
		GoogleManager manager = new GoogleManager();
		manager.register(message);
		}

}
