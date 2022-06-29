package pl.piasecki.MyWalletServer.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.model.UserRole;
import pl.piasecki.MyWalletServer.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User not found with username:" + username));
       userService.setLoggedInUser(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), mapRolesToAuthorities(user.getUserRoles()));
    }

    
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<UserRole> userRoles){
        return userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRole().getName())).collect(Collectors.toList());
    }
	
}
