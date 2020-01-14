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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tk.ocb.main.exception.UserNotFoundException;
import tk.ocb.main.model.User;
import tk.ocb.main.model.UserInformation;
import tk.ocb.main.repository.UserInformationRepository;
import tk.ocb.main.repository.UserRepository;


@RestController
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInformationRepository userInformationRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/userInformation")
	public List<UserInformation> retrieveAllUserInformation(){
		return userInformationRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		User retrievedUser = user.get();
		return retrievedUser;
	}
	
	@GetMapping("/userInformation/{id}")
	public UserInformation retrieveUserInformation(@PathVariable int id) {
		Optional<UserInformation> userInformation = userInformationRepository.findById(id);
		
		if(!userInformation.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		UserInformation retrievedUserInformation = userInformation.get();
		return retrievedUserInformation;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//id in the pathvariable represent user id 
	@PostMapping("/userInformation/{id}")
	public ResponseEntity<Object> createUserInformation(@RequestBody UserInformation userInformation,
														@PathVariable int id){
		
		userInformation.setUser(userRepository.findById(id).get());
		UserInformation savedUserInformation = userInformationRepository.save(userInformation); 
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUserInformation.getUserInformationId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//it needs to delete userinformation entry before deleting the user entry
	
	
	
}
