package tk.ocb.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="password", nullable=false, length=50)
	private String password;
	
	@Column(name="first_name", nullable=false, length=50)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=50)
	private String lastName;
	
	@Column(name="mobile_number", nullable=false, length=30)
	private String mobileNumber;
	
	@OneToOne(mappedBy="user", fetch = FetchType.LAZY)
	private UserInformation userInformation;
	
	
	
	public User() {
		
	}
	
	public User(String email, String password, String firstName, String lastName, String mobileNumber,
			UserInformation userInformation) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.userInformation = userInformation;
	}
	
	
	public User(int userId, String email, String password, String firstName, String lastName, String mobileNumber,
			UserInformation userInformation) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.userInformation = userInformation;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
	
}
