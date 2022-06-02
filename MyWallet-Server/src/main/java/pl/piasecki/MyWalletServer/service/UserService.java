package pl.piasecki.MyWalletServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
