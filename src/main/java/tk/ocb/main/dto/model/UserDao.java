package tk.ocb.main.dto.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDao{
	private int id;
	@NotEmpty(message="email can't be empty")
	@Email(message="please enter a valid email")
	private String email;
	@NotEmpty(message="password can't be empty")
	private String password;
	@NotEmpty(message="first name can't be empty")
	private String firstName;
	@NotEmpty(message="last name can't be empty")
	private String lastName;
	@NotEmpty(message="mobile number can't be empty")
	@Pattern(regexp="[0-9\\s]{11}", message = "wrong format of mobile number")
	private String mobileNumber;
	
	private UserInformationDao userInformationDao;
	

	public UserDao() {
		super();
	}

	public UserDao(int id, String email, String password, String firstName, String lastName, String mobileNumber,
			UserInformationDao userInformationDao) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.userInformationDao = userInformationDao;
	}

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

	public UserInformationDao getUserInformationDao() {
		return userInformationDao;
	}

	public void setUserInformationDao(UserInformationDao userInformationDao) {
		this.userInformationDao = userInformationDao;
	}

	@Override
	public String toString() {
		return "UserDao [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
