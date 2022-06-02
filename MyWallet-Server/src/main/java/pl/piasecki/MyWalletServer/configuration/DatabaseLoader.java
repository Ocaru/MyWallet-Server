
/*
package pl.piasecki.MyWalletServer.configuration;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.piasecki.MyWalletServer.model.Expenditure;   
import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.repository.ExpenditureRepository;
import pl.piasecki.MyWalletServer.repository.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ExpenditureRepository expenditureRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public DatabaseLoader(ExpenditureRepository expenditureRepository, UserRepository userRepository) {
		this.expenditureRepository = expenditureRepository;
		this.userRepository = userRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("ODPALENIE RUN() W DATABASE LOADER");
		userRepository.save(new User("Kamil", "Piasecki", "kamil.piasecki14@gmail.com"));
		userRepository.save(new User("Diana", "Duda", "diana_xyz@gmail.com"));
		
		expenditureRepository.save(new Expenditure("Grocery shopping", 50.30f, "Shopping in Biedra",1));
		expenditureRepository.save(new Expenditure("Food1", 15.00f, "Kebab",1));
		expenditureRepository.save(new Expenditure("Food2", 120.60f, "Two big pizzas",1));
		expenditureRepository.save(new Expenditure("Car", 12600f, "New car",1));
		expenditureRepository.save(new Expenditure("Ice-cream", 5f, "Two ice-creams",1));
		expenditureRepository.save(new Expenditure("Course", 1000f, "Course to learn programming ",1));
		



	}

}
*/
