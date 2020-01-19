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
		if(user.getUserInformation() == null) 
			userDao.setUserInformationDao(null);
		else {
			userDao.setUserInformationDao(UserInformationMapper.toUserInformationDto(user.getUserInformation()));
		}
		
		return userDao;
	}
	
	public static User toUser(UserDao userDao) {
		User user = new User();
		
		//user.setUserId(0);
		user.setEmail(userDao.getEmail());
		user.setPassword(userDao.getPassword());
		user.setFirstName(userDao.getFirstName());
		user.setLastName(userDao.getLastName());
		user.setMobileNumber(userDao.getMobileNumber());
		
		if(userDao.getUserInformationDao() == null)
			user.setUserInformation(null);
		else
			user.setUserInformation(UserInformationMapper.toUserInformation(userDao.getUserInformationDao()));
		
		return user;
	}
}
