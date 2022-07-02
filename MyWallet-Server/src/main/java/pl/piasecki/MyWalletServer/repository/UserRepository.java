package pl.piasecki.MyWalletServer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.piasecki.MyWalletServer.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u")
	List<User> findAllUsers();

	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
