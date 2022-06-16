package pl.piasecki.MyWalletServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.piasecki.MyWalletServer.model.ExpenditureCategory;

public interface ExpenditureCategoryRepository extends JpaRepository<ExpenditureCategory, Long> {

}
