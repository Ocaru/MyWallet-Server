package pl.piasecki.MyWalletServer.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pl.piasecki.MyWalletServer.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Optional<Role> findByName(String name);
}
