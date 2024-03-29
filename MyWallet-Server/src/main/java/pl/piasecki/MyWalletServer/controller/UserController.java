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

import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getSingleUser(@PathVariable long id) {
		return userService.getUser(id);
	}

	@GetMapping("/users/username={username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@GetMapping("/users/loggedIn")
	public User getLoggedInUser() {
		return userService.getLoggedInUser();
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/users")
	public User editUser(@RequestBody User user) {
		return userService.editUser(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}

}
