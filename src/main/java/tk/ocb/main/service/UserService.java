package tk.ocb.main.service;

import java.util.List;

import tk.ocb.main.dto.model.UserDao;

public interface UserService {
	
	
	
	
	
	//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	List<UserDao> findAllUser();
	
	UserDao findUserById(int id);
	
	UserDao findUserByEmail(String email);
	
	UserDao findUserByMobileNumber(String mobileNumber);
	
	List<UserDao> findUserByFirstName(String firstName);
	
	List<UserDao> findUserByLastName(String lastName);
	
	UserDao createNewUser(UserDao userDao);
	
	//List<UserDao> findUserByFirstAndLastName(String firstName, String lastName);
	//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

}
