package tk.ocb.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;


@Entity
@Table(name="user_information")
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private boolean gender;

	@OneToOne(mappedBy="userInformation", fetch=FetchType.LAZY)
	private User user;
	
	@ManyToMany
	@JoinTable(
		name="userinfo_workout",
		joinColumns = @JoinColumn(name = "user_information_id", nullable=true),
		inverseJoinColumns = @JoinColumn(name = "workout_id", nullable=true)
		)
	private List<Workout> workouts;
	

	public UserInformation() {
		
	}
	
	
	public UserInformation(int userInformationId, long height, long weigth, @Past Date dateOfBirth, boolean gender,
			User user) {
		super();
		this.userInformationId = userInformationId;
		this.height = height;
		this.weigth = weigth;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.user = user;
	}
	
	

	public UserInformation(int userInformationId, long height, long weigth, @Past Date dateOfBirth, boolean gender) {
		super();
		this.userInformationId = userInformationId;
		this.height = height;
		this.weigth = weigth;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	

	public UserInformation(long height, long weigth, @Past Date dateOfBirth, boolean gender) {
		super();
		this.height = height;
		this.weigth = weigth;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		
		this.gender = gender;
	}


		
}

