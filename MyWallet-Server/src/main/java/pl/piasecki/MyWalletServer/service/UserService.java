package pl.piasecki.MyWalletServer.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.model.Role;
import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.model.UserRole;
import pl.piasecki.MyWalletServer.repository.UserRepository;

@Service
public class UserService  {
	
	User loggedInUser;

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers()
	{
		return userRepository.findAllUsers();
	}
	
	public User getUser(long id)
	{
		return userRepository.findById(id).orElseThrow();
	}
	
	public User getUserByUsername(String username)
	{
		return userRepository.findByUsername(username).orElseThrow();
	}
	
	public User addUser(User user) {
		UserRole userRole = new UserRole(user, new Role("ROLE_USER"));
		Set<UserRole> userRoles = new HashSet<UserRole>();
		userRoles.add(userRole);
		user.setUserRoles(userRoles);
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Transactional
	public User editUser(User user)
	{
		User userEdited = userRepository.findById(user.getId()).orElseThrow();
		userEdited.setName(user.getName());
		userEdited.setSurname(user.getSurname());
		userEdited.setEmail(user.getEmail());
		userEdited.setUsername(user.getUsername());
		userEdited.setPassword(user.getPassword());
		userEdited.setUserRoles(user.getUserRoles());
		return userEdited;
	}

	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}
	
	public void setLoggedInUser(User user)
	{
		loggedInUser = user;
	}
	
	public User getLoggedInUser()
	{
		return loggedInUser;
	}
	
	
}
