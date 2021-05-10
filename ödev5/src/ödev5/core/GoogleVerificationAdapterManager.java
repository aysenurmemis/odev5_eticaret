package ödev5.core;

import ödev5.GoogleAccount.GoogleManager;
import ödev5.dataAccess.abstracts.UserDao;

public class GoogleVerificationAdapterManager implements VerificationService{

	@Override
	public void registerToGoogle(String message) {
		GoogleManager manager = new GoogleManager();
		manager.register(message);
		}

}
