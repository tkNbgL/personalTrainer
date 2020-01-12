package tk.ocb.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.ocb.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
