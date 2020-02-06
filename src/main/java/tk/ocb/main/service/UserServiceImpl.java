package tk.ocb.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import tk.ocb.main.dto.mapper.UserInformationMapper;
import tk.ocb.main.dto.mapper.UserMapper;
import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.dto.model.UserInformationDao;
import tk.ocb.main.exception.UserNotFoundException;
import tk.ocb.main.model.User;
import tk.ocb.main.model.UserInformation;
import tk.ocb.main.repository.UserInformationRepository;
import tk.ocb.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDao> findAllUser() {
		// TODO Auto-generated method stub
		List<User> user = userRepository.findAll();
		List<UserDao> userDao = user.stream()
				.map((i) -> UserMapper.toUserDto(i)).collect(Collectors.toList());
		return userDao;
	}

	@Override
	public UserDao findUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id- " + id);
		}
		
		return UserMapper.toUserDto(user.get());
	}

	@Override
	public UserDao findUserByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByEmail(email);
		return UserMapper.toUserDto(user.get());
	}

	@Override
	public UserDao findUserByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByMobileNumber(mobileNumber);
		return UserMapper.toUserDto(user.get());
	}

	@Override
	public List<UserDao> findUserByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findByFirstName(firstName);
		List<UserDao> userDao = users.stream()
				.map(i -> UserMapper.toUserDto(i)).collect(Collectors.toList());
		return userDao;
	}

	@Override
	public List<UserDao> findUserByLastName(String lastName) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findByLastName(lastName);
		List<UserDao> userDao = users.stream()
				.map(i -> UserMapper.toUserDto(i)).collect(Collectors.toList());
		return userDao;
	}

	@Override
	public User createNewUser(UserDao userDao) {
		// TODO Auto-generated method stub
		String pw_hash = BCrypt.hashpw(userDao.getPassword(), BCrypt.gensalt());
		userDao.setPassword(pw_hash);
		User newUser = UserMapper.toUser(userDao);
		logger.info("id of the newly created entity --> {}",userRepository.save(newUser).getUserId());
		return newUser;
	}

	@Override
	public User updateUser(UserDao userDao, int id) {
		// TODO Auto-generated method stub
		if(userRepository.findById(id).isPresent()) {
			User existedUser = userRepository.findById(id).get();
			
			existedUser.setEmail(userDao.getEmail());
			existedUser.setFirstName(userDao.getFirstName());
			existedUser.setLastName(userDao.getLastName());
			existedUser.setMobileNumber(userDao.getMobileNumber());
			existedUser.setPassword(userDao.getPassword());
			
			if(userDao.getUserInformationDao() != null)
				existedUser
				.setUserInformation(UserInformationMapper
						.toUserInformation(userDao.getUserInformationDao()));
			else
				existedUser.setUserInformation(null);
			
			User updatedUser = userRepository.save(existedUser);
			
			return updatedUser;
		}else {
			return null;
		}
		
	}

	@Override
	public User deleteUser(int id) {
		// TODO Auto-generated method stub
		Optional<User> deletedUser = userRepository.findById(id);
		
		if(deletedUser.isPresent()) {
			logger.info("user is deleted");
			userRepository.deleteById(id);
		}
		//exception handling in here
		
		return deletedUser.get();
	}

	@Override
	public User UpdateUserInformation(int userId, UserInformationDao userInformationDao) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).get();
		UserInformation userInformation = UserInformationMapper.toUserInformation(userInformationDao);
		user.setUserInformation(userInformation);	
		userRepository.save(user);
		return user;
	}

	
	

}
