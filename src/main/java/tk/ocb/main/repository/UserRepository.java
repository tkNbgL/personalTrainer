package tk.ocb.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.ocb.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
	Optional<User> findByMobileNumber(String mobileNumber);
	List<User> findByFirstName(String FirstName);
	List<User> findByLastName(String LastName);
}
