package tk.ocb.main.dto.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

public class UserInformationDao {
	@Min(value=150, message = "min is 150")
	@Max(value=200, message = "max is 200")
	private long height;
	@Min(value=40, message="min is 40")
	@Max(value=100, message="max is 100")
	private long weigth;
	
	@Past
	private Date dateOfBirth;
	
	private boolean gender;
	
	

	public UserInformationDao() {
		super();
	}

	public UserInformationDao(long height, long weigth, Date dateOfBirth, boolean gender) {
		super();
		this.height = height;
		this.weigth = weigth;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserInformationDao [height=" + height + ", weigth=" + weigth + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}
	
	
}
