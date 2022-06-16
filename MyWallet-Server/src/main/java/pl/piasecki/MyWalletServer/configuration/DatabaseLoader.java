/*
package pl.piasecki.MyWalletServer.configuration;


import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.piasecki.MyWalletServer.model.Expenditure;
import pl.piasecki.MyWalletServer.model.ExpenditureCategory;
import pl.piasecki.MyWalletServer.model.User;
import pl.piasecki.MyWalletServer.repository.ExpenditureCategoryRepository;
import pl.piasecki.MyWalletServer.repository.ExpenditureRepository;
import pl.piasecki.MyWalletServer.repository.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ExpenditureRepository expenditureRepository;
	private final UserRepository userRepository;
	private final ExpenditureCategoryRepository expenditureCategoryRepository;
	
	@Autowired
	public DatabaseLoader(ExpenditureRepository expenditureRepository, UserRepository userRepository, ExpenditureCategoryRepository expenditureCategoryRepository) {
		this.expenditureRepository = expenditureRepository;
		this.userRepository = userRepository;
		this.expenditureCategoryRepository = expenditureCategoryRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		
		userRepository.save(new User("Kamil", "Piasecki", "kamil.piasecki14@gmail.com"));
		userRepository.save(new User("Diana", "Duda", "diana333.97@gmail.com"));
		
		expenditureCategoryRepository.save(new ExpenditureCategory(1, "Food"));
		expenditureCategoryRepository.save(new ExpenditureCategory(2, "Clothes"));
		expenditureCategoryRepository.save(new ExpenditureCategory(3, "Electronics"));
		expenditureCategoryRepository.save(new ExpenditureCategory(4, "Home"));
		expenditureCategoryRepository.save(new ExpenditureCategory(5, "Transport"));
		expenditureCategoryRepository.save(new ExpenditureCategory(6, "Entertainment"));
		expenditureCategoryRepository.save(new ExpenditureCategory(7, "Health & hygiene"));
		expenditureCategoryRepository.save(new ExpenditureCategory(8, "Furniture & accessories"));
		expenditureCategoryRepository.save(new ExpenditureCategory(9, "AGD"));

		
		
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(50.30), Date.valueOf("2022-06-01"),"Shopping in Biedronka", 1l, 1l));
		expenditureRepository.save(new Expenditure("New car", new BigDecimal(50000),  Date.valueOf( "2022-06-02" ),"Ford Fiesta", 1l, 4l));
		expenditureRepository.save(new Expenditure("Pizza", new BigDecimal(79.99),  Date.valueOf( "2022-06-05" ),"Big pizza in Dominos", 2l, 1l));
		expenditureRepository.save(new Expenditure("Iron", new BigDecimal(215),  Date.valueOf( "2022-06-05" ),"Iron", 2l, 9l));
		expenditureRepository.save(new Expenditure("Computer mouse", new BigDecimal(300),  Date.valueOf( "2022-06-08" ),"New mouse Logitech G Pro", 1l, 3l));
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(143.89),  Date.valueOf( "2022-06-08" ),"Shopping in Biedronka", 1l, 1l));
		expenditureRepository.save(new Expenditure("T-shirts", new BigDecimal(110.50),  Date.valueOf( "2022-06-09" ),"Shopping in Zalando Launge", 1l, 2l));
		expenditureRepository.save(new Expenditure("Kitchen accessories ", new BigDecimal(70),  Date.valueOf( "2022-06-11" ),"Shopping in Carefoura", 1l, 4l));
		expenditureRepository.save(new Expenditure("Grocery shopping", new BigDecimal(99.45),  Date.valueOf( "2022-06-12" ),"Shopping in Lidl", 2, 1l));
		expenditureRepository.save(new Expenditure("Shampoo", new BigDecimal(12.70),  Date.valueOf( "2022-06-12" ),"Shampoo bought on Allegro", 2l, 7l));
		

	}

}

*/