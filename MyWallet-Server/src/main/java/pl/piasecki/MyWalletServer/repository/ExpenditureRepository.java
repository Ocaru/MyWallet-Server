package pl.piasecki.MyWalletServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.piasecki.MyWalletServer.model.Expenditure;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

	@Query("SELECT e FROM Expenditure e")
	List<Expenditure> findAllExpenditure();

	@Query("SELECT e FROM Expenditure e WHERE user_id = ?1")
	List<Expenditure> findExpenditureByUser_id(long user_id);
}
