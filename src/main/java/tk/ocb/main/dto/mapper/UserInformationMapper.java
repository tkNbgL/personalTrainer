package tk.ocb.main.dto.mapper;

import org.springframework.stereotype.Component;

import tk.ocb.main.dto.model.UserInformationDao;
import tk.ocb.main.model.UserInformation;

@Component
public class UserInformationMapper {
	public static UserInformationDao
		toUserInformationDto(UserInformation userInformation) {
		
		UserInformationDao userInformationDao = new UserInformationDao();
		
		userInformationDao.setHeight(userInformation.getHeight());
		
		userInformationDao.setWeigth(userInformation.getWeigth());
		
		userInformationDao.setDateOfBirth(userInformation.getDateOfBirth());
		
		userInformationDao.setGender(userInformation.getGender());
		
		return userInformationDao;
	}
}
