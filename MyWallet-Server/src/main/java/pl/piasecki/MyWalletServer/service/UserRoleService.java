package pl.piasecki.MyWalletServer.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.model.UserRole;
import pl.piasecki.MyWalletServer.repository.UserRoleRepository;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public List<UserRole> getUserRoles()
	{
		List<UserRole> userRoleList = userRoleRepository.findAllUserRoles();
		for (UserRole userRole : userRoleList) {
			System.out.println(userRole.toString());
		}
		return userRoleList;
	}
	
	public UserRole getUserRole(long id)
	{
		return userRoleRepository.findById(id).orElseThrow();
	}
	
	public UserRole getUserByIdUserAndIdRole(long idUser, long idRole)
	{
		return userRoleRepository.findByIdUserAndIdRole(idUser, idRole).orElseThrow();
	}
	
	public UserRole addUserRole(UserRole userRole) {

		
		return userRoleRepository.save(userRole);
	}
	
	@Transactional
	public UserRole editUserRole(UserRole userRole)
	{
		UserRole userRoleEdited = userRoleRepository.findById(userRole.getId()).orElseThrow();
		userRoleEdited.setUser(userRoleEdited.getUser());
		userRoleEdited.setRole(userRoleEdited.getRole());
		return userRoleEdited;
	}

	public void deleteUserRole(long id) {
		userRoleRepository.deleteById(id);
		
	}
	
}
