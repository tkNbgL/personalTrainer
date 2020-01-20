package tk.ocb.main.restController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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


import tk.ocb.main.dto.mapper.UserMapper;
import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.dto.model.UserInformationDao;
import tk.ocb.main.exception.UserNotFoundException;
import tk.ocb.main.model.User;
import tk.ocb.main.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userServiceImpl;
	
	@GetMapping("/users")
	public List<UserDao> retrieveAllUsers(){
		return userServiceImpl.findAllUser();
	}
	
//	ResourceSupport is now RepresentationModel
//
//	Resource is now EntityModel
//
//	Resources is now CollectionModel
//
//	PagedResources is now PagedModel
	
	@GetMapping("/users/{id}")
	public EntityModel<UserDao> findUserById(@PathVariable int id) {
		UserDao userDao = userServiceImpl.findUserById(id);
		
		if(userDao == null) {
			throw new UserNotFoundException("id- " + id);
		}
		
		EntityModel<UserDao> entityModel = new EntityModel<>(userDao);
		WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(linkTo.withRel("all-users"));
		
		return entityModel;
	}
	
	@GetMapping("/email/{email}")
	public UserDao findUserByEmail(@PathVariable String email) {
		return userServiceImpl.findUserByEmail(email);
	}
	
	
	@GetMapping("/phone/{mobileNumber}")
	public UserDao findUserByMobileNumber(@PathVariable String mobileNumber) {
		return userServiceImpl.findUserByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/name/{firstName}")
	public List<UserDao> findUserByFirstName(@PathVariable String firstName) {
		return userServiceImpl.findUserByFirstName(firstName);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<UserDao> findUserByLastName(@PathVariable String lastName){
		return userServiceImpl.findUserByLastName(lastName);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDao userDao){
		User savedUser = userServiceImpl.createNewUser(userDao);
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedUser.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDao userDao, @PathVariable int id){
		User updatedUser = userServiceImpl.updateUser(userDao, id);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(updatedUser.getUserId()).toUri();
		
		return ResponseEntity.ok(location);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		User deletedUser = userServiceImpl.deleteUser(id);
		return ResponseEntity.ok().body(UserMapper.toUserDto(deletedUser));
	}
	
	@PutMapping("/users/userinformation/{id}")
	public ResponseEntity<Object> updateUserInformation(@PathVariable int id,
											@Valid @RequestBody UserInformationDao userInformationDao){
		User user = userServiceImpl.UpdateUserInformation(id, userInformationDao);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getUserId()).toUri();
		
		return ResponseEntity.ok(location);
	}
	
}
