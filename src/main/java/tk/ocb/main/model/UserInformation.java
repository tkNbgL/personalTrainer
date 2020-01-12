package tk.ocb.main.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import com.sun.istack.Nullable;

@Entity
@Table(name="user_information")
public class UserInformation {
	@Id
	@GeneratedValue
	@Column(name="user_information_id")
	private int userInformationId;
	
	@Column(name="height", nullable=false)
	private long height;
	
	@Column(name="weight", nullable=false)
	private long weigth;
	
	//@Column(name="date_of_birth", nullable=false)
	//@Temporal(TemporalType.DATE)
	@Past
	private Date dateOfBirth;
	
	@Column(name="gender", nullable=false)
	private Gender gender;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user;
	
	
	public UserInformation() {
		
	}
	
	
	public UserInformation(int userInformationId, long height, long weigth, @Past Date dateOfBirth, Gender gender,
			User user) {
		super();
		this.userInformationId = userInformationId;
		this.height = height;
		this.weigth = weigth;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.user = user;
	}
	
	
	public int getUserInformationId() {
		return userInformationId;
	}
	public void setUserInformationId(int userInformationId) {
		this.userInformationId = userInformationId;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public long getWeigth() {
		return weigth;
	}
	public void setWeigth(long weigth) {
		this.weigth = weigth;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		
}

enum Gender{
	Male, Female
}
