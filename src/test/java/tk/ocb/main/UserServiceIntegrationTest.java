package tk.ocb.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import tk.ocb.main.dto.model.UserDao;
import tk.ocb.main.model.User;
import tk.ocb.main.repository.UserRepository;
import tk.ocb.main.service.UserService;
import tk.ocb.main.service.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceIntegrationTest {
	
	@TestConfiguration
	static class UserServiceIntegrationTestContextConfiguration{
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}
	
	@Autowired
	private UserService userService;
	@MockBean
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		User utku = new User("utku.nebioglu@gmail.com", "123456", "utku", "nebioglu", "05348991122");
		int id = 1;
		
		Mockito.when(userRepository.findByEmail(utku.getEmail())).thenReturn(Optional.of(utku));
		Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(utku));
		Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(utku));
		Mockito.when(userRepository.findByMobileNumber(utku.getMobileNumber())).thenReturn(Optional.of(utku));
		Mockito.when(userRepository.findByFirstName(utku.getFirstName())).thenReturn(Arrays.asList(utku));
		Mockito.when(userRepository.findByLastName(utku.getLastName())).thenReturn(Arrays.asList(utku));
	}
	
	@Test
	public void whenLastName_whenUserShouldBeReturned() {
		String lastName = "nebioglu";
		List<UserDao> foundUsers = userService.findUserByLastName(lastName);
		
		assertThat(foundUsers.get(0).getLastName()).isEqualTo(lastName);
	}
	
	@Test
	public void whenFirstName_thenUserShouldBeReturned() {
		String firstName = "utku";
		List<UserDao> foundUsers = userService.findUserByFirstName(firstName);
		
		assertThat(foundUsers.get(0).getFirstName()).isEqualTo(firstName);
	}
	
	@Test
	public void whenMobilePhoneNumber_thenUserShouldBeReturned() {
		String phoneNumber = "05348991122";
		UserDao foundUser = userService.findUserByMobileNumber(phoneNumber);
		
		assertThat(foundUser.getMobileNumber()).isEqualTo(phoneNumber);
	}
	
	@Test
	public void whenUserId_thenUserShouldBeReturned() {
		String userName = "utku";
		UserDao foundUser = userService.findUserById(1);
		
		assertThat(foundUser.getFirstName()).isEqualTo(userName);
	}
	
	@Test
	public void whenUserAll_thenAllUserShouldBeReturned() {
		String firstUserName= "utku";
		List<UserDao> foundUsers = userService.findAllUser();
		
		assertThat(foundUsers.get(0).getFirstName()).isEqualTo(firstUserName);
	}
	
	@Test
	public void whenUserEmail_thenUserShouldBeReturned() {
		String email = "utku.nebioglu@gmail.com";
		UserDao foundUser = userService.findUserByEmail(email);
		
		assertThat(foundUser.getEmail()).isEqualTo(email);
	}
}
