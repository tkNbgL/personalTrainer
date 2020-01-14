package tk.ocb.main.dto.model;

import tk.ocb.main.model.UserInformation;

public class UserDao {
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private UserInformation userInformation;
	

	public UserDao() {
		super();
	}

	public UserDao(String email, String password, String firstName, String lastName, String mobileNumber,
			UserInformation userInformation) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.userInformation = userInformation;
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
	
	

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String toString() {
		return "UserDao [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
