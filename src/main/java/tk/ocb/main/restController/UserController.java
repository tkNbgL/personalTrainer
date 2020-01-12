package tk.ocb.main.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tk.ocb.main.exception.UserNotFoundException;
import tk.ocb.main.model.User;
import tk.ocb.main.repository.UserInformationRepository;
import tk.ocb.main.repository.UserRepository;


@RestController("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInformationRepository userInformationRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		User retrievedUser = user.get();
		return retrievedUser;
	}
	
	
}
