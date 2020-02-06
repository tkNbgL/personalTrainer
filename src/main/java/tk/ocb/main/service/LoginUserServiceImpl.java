package tk.ocb.main.service;

import java.security.AccessControlException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import tk.ocb.main.dto.mapper.UserMapper;
import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.model.User;
import tk.ocb.main.repository.UserRepository;

@Service
public class LoginUserServiceImpl implements LoginUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDao takePasswordNEmailReturnUser(String email, String password) {
		User user = userRepository.findByEmail(email).orElseThrow();
		
		if(BCrypt.checkpw(password, user.getPassword()))
			return UserMapper.toUserDto(user);
		else
			throw new AccessControlException("wrong pw or email");
	}

}
