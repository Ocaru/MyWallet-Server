
package pl.piasecki.MyWalletServer.configuration;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.piasecki.MyWalletServer.model.Expenditure;
import pl.piasecki.MyWalletServer.model.ExpenditureCategory;
import pl.piasecki.MyWalletServer.model.Role;
import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.repository.ExpenditureCategoryRepository;
import pl.piasecki.MyWalletServer.repository.ExpenditureRepository;
import pl.piasecki.MyWalletServer.repository.RoleRepository;
import pl.piasecki.MyWalletServer.repository.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ExpenditureRepository expenditureRepository;
	private final UserRepository userRepository;
	private final ExpenditureCategoryRepository expenditureCategoryRepository;
	private final RoleRepository roleRepository;
	
	public DatabaseLoader(ExpenditureRepository expenditureRepository, UserRepository userRepository, 
			ExpenditureCategoryRepository expenditureCategoryRepository, RoleRepository roleRepository) {
		this.expenditureRepository = expenditureRepository;
		this.userRepository = userRepository;
		this.expenditureCategoryRepository = expenditureCategoryRepository;
		this.roleRepository = roleRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		if(roleRepository.count() == 0 
			&& userRepository.count() == 0
			&& expenditureCategoryRepository.count() == 0 
			&& expenditureRepository.count() == 0)
		{
			insertIntoDatabase();
		}

	}
	
	private void insertIntoDatabase()
	{
		Role role1 = new Role("ROLE_ADMIN");
		roleRepository.save(role1);
		Role role2 = new Role("ROLE_USER");
		roleRepository.save(role2);
		
		Set<Role> roleSet1 = new HashSet<Role>();
		roleSet1.add(role1);
		roleSet1.add(role2);
		
		Set<Role> roleSet2 = new HashSet<Role>();
		roleSet2.add(role2);

		User user1 = new User("Kamil", "Piasecki", "admin", "$2a$10$PeHrspV0uLs8/HHJLfuVG.tO4nqjphw6p4WsopXUhr3q2JEJc/PKS", "kamil.piasecki14@gmail.com", roleSet1); //password: qwe456
		User user2 = new User("Marek", "Kowalski", "user","$2a$10$PeHrspV0uLs8/HHJLfuVG.tO4nqjphw6p4WsopXUhr3q2JEJc/PKS",  "kowalski.marek@gmail.com", roleSet2); //password: qwe456
		userRepository.save(user1);
		userRepository.save(user2);
		
		expenditureCategoryRepository.save(new ExpenditureCategory("Food"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Clothes"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Electronics"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Home"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Transport"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Entertainment"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Health & hygiene"));
		expenditureCategoryRepository.save(new ExpenditureCategory("Furniture & accessories"));
		expenditureCategoryRepository.save(new ExpenditureCategory("AGD"));

		expenditureRepository.save(new Expenditure("Tickets",  new BigDecimal(48.00), Date.valueOf("2022-03-29"), "2 x 24-hours tickets", 2, 5));
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(205.65), Date.valueOf("2022-03-29"), "Grocery shopping", 1, 1));
		expenditureRepository.save(new Expenditure("Rent", new BigDecimal(1200.00), Date.valueOf("2022-04-05"), "Rent for May", 1, 4)); 
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(250.90), Date.valueOf("2022-04-15"), "Grocery shopping", 1, 1));
		expenditureRepository.save(new Expenditure("Party", new BigDecimal(150.00), Date.valueOf("2022-05-18"), "Clubbing", 1, 6)); 
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(185.00), Date.valueOf("2022-05-20"), "Grocery shopping", 2, 1));
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(50.30), Date.valueOf("2022-06-01"), "Shopping", 1, 1));  
		expenditureRepository.save(new Expenditure("Ticket", new BigDecimal(24.00), Date.valueOf("2022-06-02"), "24-hours ticket", 1, 5));  
		expenditureRepository.save(new Expenditure("Pizza", new BigDecimal(79.99), Date.valueOf("2022-06-05"), "Big pizza", 2, 1));
		expenditureRepository.save(new Expenditure("Iron", new BigDecimal(255.00), Date.valueOf("2022-06-05"), "New Iron", 2, 9));
		expenditureRepository.save(new Expenditure("Electric kettle", new BigDecimal(120.00), Date.valueOf("2022-06-07"), "New electric kettle", 2, 9));
		expenditureRepository.save(new Expenditure("Computer mouse", new BigDecimal(300.00), Date.valueOf("2022-06-08"), "New mouse Logitech", 1, 3));
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(143.89), Date.valueOf("2022-06-08"), "Shopping", 1, 1)); 
		expenditureRepository.save(new Expenditure("T-shirts", new BigDecimal(110.50), Date.valueOf("2022-06-09"), "Zalando Launge", 1, 2));
		expenditureRepository.save(new Expenditure("Kitchen accessories", new BigDecimal(70.00), Date.valueOf("2022-06-11"), "Carefour", 1, 4)); 
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(99.45), Date.valueOf("2022-06-12"), "Shopping in Lidl", 2, 1)); 
		expenditureRepository.save(new Expenditure("Shower gels", new BigDecimal(32.70), Date.valueOf("2022-06-12"), "Bought from one of the auction sites", 2, 7));
		expenditureRepository.save(new Expenditure("Prince Polo", new BigDecimal(3.00), Date.valueOf("2022-06-13"), "Chocolate bar", 1, 1)); 
		expenditureRepository.save(new Expenditure("Armchair", new BigDecimal(500.00), Date.valueOf("2022-06-13"), "Blue Armchair", 2, 8)); 
		expenditureRepository.save(new Expenditure("Hot-dog", new BigDecimal(9.00), Date.valueOf("2022-06-13"), "Hot-dog", 1, 1)); 
		expenditureRepository.save(new Expenditure("Printer", new BigDecimal(450.00), Date.valueOf("2022-06-14"), "New printer", 1, 3)); 
		expenditureRepository.save(new Expenditure("Shampoo", new BigDecimal(50.00), Date.valueOf("2022-06-17"), "Head&Shoulders x3", 2, 7)); 
		expenditureRepository.save(new Expenditure("Detergents",  new BigDecimal(59.99), Date.valueOf("2022-06-20"), "Laundry detergents", 1, 7));
		expenditureRepository.save(new Expenditure("Tickets",  new BigDecimal(250.00), Date.valueOf("2022-07-01"), "Monthly ticket", 2, 5));
	}

}

