package tk.ocb.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.ocb.main.dto.mapper.UserInformationMapper;
import tk.ocb.main.dto.mapper.UserMapper;
import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.exception.UserNotFoundException;
import tk.ocb.main.model.User;
import tk.ocb.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
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
	public UserDao createNewUser(UserDao userDao) {
		// TODO Auto-generated method stub
		userRepository.save(userDao);
	}

	

}
