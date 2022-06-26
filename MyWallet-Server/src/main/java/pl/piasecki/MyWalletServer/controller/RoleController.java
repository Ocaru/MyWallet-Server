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

import pl.piasecki.MyWalletServer.model.Role;
import pl.piasecki.MyWalletServer.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public List<Role> getRoles()
	{
		return roleService.getRoles();
	}
	
	@GetMapping("/roles/{id}")
	public Role getSingleRole(@PathVariable long id)
	{
		return roleService.getRole(id);
	}
	
	@PostMapping("/roles")
	public Role addRole(@RequestBody Role role)
	{
		return roleService.addRole(role);
	}
	
	@PutMapping("/roles")
	public Role editRole(@RequestBody Role role)
	{
		return roleService.editRole(role);
	}
	
	@DeleteMapping("/roles/{id}")
	public void deleteRole(@PathVariable long id)
	{
		roleService.deleteRole(id);
	}
}
