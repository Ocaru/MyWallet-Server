package pl.piasecki.MyWalletServer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.model.Expenditure;
import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.repository.UserRepository;

@Service
public class UserService {

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
	
	public User addUser(User user) {
		
		return userRepository.save(user);
	}
	
	@Transactional
	public User editUser(User user)
	{
		User userEdited = userRepository.findById(user.getId()).orElseThrow();
		userEdited.setName(user.getName());
		userEdited.setSurname(user.getSurname());
		userEdited.setEmail(user.getEmail());
		return userEdited;
	}

	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}
	
	
}
