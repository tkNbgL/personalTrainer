package tk.ocb.main.dto.model;

import java.util.Date;

public class UserInformationDao {
	private long height;
	
	private long weigth;
	
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
