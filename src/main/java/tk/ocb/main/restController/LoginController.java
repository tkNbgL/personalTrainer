package tk.ocb.main.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.ocb.main.dto.model.LoginUser;
import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.service.LoginUserService;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginUserService loginUserService;
	
	@PostMapping("/")
	public UserDao logIn(@RequestBody LoginUser loginUser) {
		return loginUserService.takePasswordNEmailReturnUser(loginUser.getEmail(), loginUser.getPassword());
	}
}
