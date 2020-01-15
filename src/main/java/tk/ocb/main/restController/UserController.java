package tk.ocb.main.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.exception.UserNotFoundException;
import tk.ocb.main.model.User;
import tk.ocb.main.model.UserInformation;
import tk.ocb.main.repository.UserInformationRepository;
import tk.ocb.main.repository.UserRepository;
import tk.ocb.main.service.UserService;
import tk.ocb.main.service.UserServiceImpl;


@RestController
@RequestMapping("user")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private UserInformationRepository userInformationRepository;
	
	@GetMapping("/users")
	public List<UserDao> retrieveAllUsers(){
		return userServiceImpl.findAllUser();
	}
	
	@GetMapping("/users/{id}")
	public UserDao findUserById(@PathVariable int id) {
		return userServiceImpl.findUserById(id);
	}
	
	@GetMapping("/email/{email}")
	public UserDao findUserByEmail(@PathVariable String email) {
		return userServiceImpl.findUserByEmail(email);
	}
	
	
	@GetMapping("/phone/")
	public UserDao findUserByMobileNumber(@PathVariable String mobileNumber) {
		return userServiceImpl.findUserByMobileNumber(mobileNumber);
	}
	
	public List

}
