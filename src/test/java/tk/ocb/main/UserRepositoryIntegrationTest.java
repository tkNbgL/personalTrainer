package tk.ocb.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import tk.ocb.main.model.User;
import tk.ocb.main.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
//	Optional<User> findByEmail(String email);
//	Optional<User> findByMobileNumber(String mobileNumber);
//	List<User> findByFirstName(String FirstName);
//	List<User> findByLastName(String LastName);
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void whenFindByEmail_thenReturnUser() {
		User utku = new User("utku.nebioglu@gmail.com", "123456", "utku", "nebioglu", "05348991122");
		entityManager.persist(utku);
		entityManager.flush();
		
		//when
		User found = userRepository.findByEmail(utku.getEmail()).get();
		
		//given
		assertThat(found.getMobileNumber()).isEqualTo(utku.getMobileNumber());
	}
	
	@Test
	public void whenFindByMobileNumber_thenReturnUser() {
		User utku = new User("utku.nebioglu@gmail.com", "123456", "utku", "nebioglu", "05348991122");
		entityManager.persist(utku);
		entityManager.flush();
		
		//when
		User found = userRepository.findByMobileNumber(utku.getMobileNumber()).get();
		
		//given
		assertThat(found.getMobileNumber()).isEqualTo(utku.getMobileNumber());
	}
	
	@Test
	public void whenFindByLastName_thenReturnUser() {
		User utku = new User("utku.nebioglu@gmail.com", "123456", "utku", "nebioglu", "05348991122");
		entityManager.persist(utku);
		entityManager.flush();
		
		//when
		List<User> found = userRepository.findByLastName(utku.getLastName());
		
		//then
		assertThat(found.get(0).getLastName()).isEqualTo(utku.getLastName());
	}
	
	@Test
	public void whenFindByFirstName_thenReturnUser() {
		//given//'utku.nebioglu@gmail.com', '123456', 'utku', 'nebioglu', '05348991122'
		User utku = new User("utku.nebioglu@gmail.com", "123456", "utku", "nebioglu", "05348991122");
		entityManager.persist(utku);
		entityManager.flush();
		
		//when
		List<User> found = userRepository.findByFirstName(utku.getFirstName());
		
		//then
		assertThat(found.get(0).getFirstName()).isEqualTo(utku.getFirstName());
	}
	
}