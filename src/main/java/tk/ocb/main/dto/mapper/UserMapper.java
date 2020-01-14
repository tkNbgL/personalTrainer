package tk.ocb.main.dto.mapper;

import org.springframework.stereotype.Component;

import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.model.User;

@Component
public class UserMapper {
	
	public static UserDao toUserDto(User user) {
		UserDao userDao = new UserDao();
		
		userDao.setEmail(user.getEmail());
		userDao.setPassword(user.getPassword());
		userDao.setFirstName(user.getFirstName());
		userDao.setLastName(user.getLastName());
		userDao.setMobileNumber(user.getMobileNumber());
		userDao.setUserInformationDao(UserInformationMapper.toUserInformationDto(user.getUserInformation()));
		
		return userDao;
	}
}
