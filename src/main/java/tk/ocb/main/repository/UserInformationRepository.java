package tk.ocb.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tk.ocb.main.model.UserInformation;

@Repository
public interface UserInformationRepository
				extends JpaRepository<UserInformation, Integer>{

}
