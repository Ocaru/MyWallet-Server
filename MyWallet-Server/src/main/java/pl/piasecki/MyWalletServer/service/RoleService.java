package pl.piasecki.MyWalletServer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.model.Role;
import pl.piasecki.MyWalletServer.repository.RoleRepository;


@Service
public class RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles()
	{
		return roleRepository.findAllRoles();
	}
	
	public Role getRole(long id)
	{
		return roleRepository.findById(id).orElseThrow();
	}
	
	public Role addRole(Role role) {
		
		return roleRepository.save(role);
	}
	
	@Transactional
	public Role editRole(Role role)
	{
		Role roleEdited = roleRepository.findById(role.getId()).orElseThrow();
		roleEdited.setName(role.getName());
		return roleEdited;
	}

	public void deleteRole(long id) {
		roleRepository.deleteById(id);
		
	}
	
}
