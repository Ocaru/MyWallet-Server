package pl.piasecki.MyWalletServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import pl.piasecki.MyWalletServer.configuration.springSecurityConfig.PasswordEncoderGenerator;


@SpringBootApplication
public class WalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);

		//PasswordEncoderGenerator.generatePassword("qwe456");
	}

}
