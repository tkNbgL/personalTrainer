package tk.ocb.main.dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.model.User;
import tk.ocb.main.service.UserService;

@Component
public class DummyDataLoader implements ApplicationRunner{

	@Autowired
	private UserService userService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		userService.createNewUser(new UserDao(1,"utku.nebioglu@gmail.com", "1234", "utku", "nebioglu", "5348991122",null));
		userService.createNewUser(new UserDao(2,"utku.nebioglu2@gmail.com", "12345", "utku2", "nebioglu2", "5348991123",null));
		userService.createNewUser(new UserDao(3,"utku.nebioglu3@gmail.com", "123456", "utku3", "nebioglu3", "5348991124",null));
	}

}
