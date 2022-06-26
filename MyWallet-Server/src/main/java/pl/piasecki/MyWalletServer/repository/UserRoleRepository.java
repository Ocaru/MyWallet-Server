package pl.piasecki.MyWalletServer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

		
		@Query("SELECT u FROM UserRole u")
		List<UserRole> findAllUserRoles();
		
		Optional<UserRole> findByIdUserAndIdRole(long idUser, long idRole);
}
