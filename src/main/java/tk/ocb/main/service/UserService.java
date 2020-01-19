package tk.ocb.main.service;

import java.util.List;

import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.dto.model.UserInformationDao;
import tk.ocb.main.model.User;

public interface UserService {
	
	
	
	
	
	//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	List<UserDao> findAllUser();
	
	UserDao findUserById(int id);
	
	UserDao findUserByEmail(String email);
	
	UserDao findUserByMobileNumber(String mobileNumber);
	
	List<UserDao> findUserByFirstName(String firstName);
	
	List<UserDao> findUserByLastName(String lastName);
	
	User createNewUser(UserDao userDao);
	
	User UpdateUserInformation(int userId, UserInformationDao userInformationDao);
	
	User updateUser(UserDao userDao, int id);
	
	User deleteUser(int id);
	
	
	
	//List<UserDao> findUserByFirstAndLastName(String firstName, String lastName);
	//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

}
