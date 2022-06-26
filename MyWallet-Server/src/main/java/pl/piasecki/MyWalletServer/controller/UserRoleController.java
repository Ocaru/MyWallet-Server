package pl.piasecki.MyWalletServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piasecki.MyWalletServer.model.UserRole;
import pl.piasecki.MyWalletServer.service.UserRoleService;


@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping("/userRoles")
	public List<UserRole> getUserRoles()
	{
		return userRoleService.getUserRoles();
	}
	
	@GetMapping("/userRoles/{id}")
	public UserRole getSingleUserRole(@PathVariable long id)
	{
		return userRoleService.getUserRole(id);
	}
	
	@GetMapping("/userRoles/idUser={idUser}&idRole={idRole}")
	public UserRole getUserRole(@PathVariable long idUser, @PathVariable long idRole)
	{
		return userRoleService.getUserByIdUserAndIdRole(idUser, idRole);
	}
	
	@PostMapping("/userRoles")
	public UserRole addUserRole(@RequestBody UserRole userRole)
	{
		return userRoleService.addUserRole(userRole);
	}
	
	@PutMapping("/userRoles")
	public UserRole editUserRole(@RequestBody UserRole userRole)
	{
		return userRoleService.editUserRole(userRole);
	}
	
	@DeleteMapping("/userRoles/{id}")
	public void deleteUserRole(@PathVariable long id)
	{
		userRoleService.deleteUserRole(id);
	}
}
