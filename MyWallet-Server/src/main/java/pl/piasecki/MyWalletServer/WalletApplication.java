package pl.piasecki.MyWalletServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
		
       // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //System.out.println("Password: " + passwordEncoder.encode("qwe456"));
	}
	
}
