package pl.piasecki.MyWalletServer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.exception.ExpenditureNotFoundException;
import pl.piasecki.MyWalletServer.model.Expenditure;
import pl.piasecki.MyWalletServer.repository.ExpenditureRepository;


@Service
public class ExpenditureService {

	@Autowired
	private ExpenditureRepository expenditureRepository;
	
	public List<Expenditure> getExpenditures()
	{
		return expenditureRepository.findAllExpenditure();
	}
	
	public Expenditure getExpenditure(long id)
	{
		return expenditureRepository.findById(id).orElseThrow(() -> new ExpenditureNotFoundException(id));
	}
	
	public List<Expenditure> getExpenditureByUser_id(long user_id)
	{
		return expenditureRepository.findExpenditureByUser_id(user_id);
	}
	

	public Expenditure addExpenditure(Expenditure expenditure) {
		
		return expenditureRepository.save(expenditure);
	}

	@Transactional //zeby zamiast dwoch transakcji wykonalo sie w jednej transakcji
	public Expenditure editExpenditure(Expenditure expenditure)
	{
		Expenditure expenditureEdited = expenditureRepository.findById(expenditure.getId()).orElseThrow();
		expenditureEdited.setName(expenditure.getName());
		expenditureEdited.setMoney(expenditure.getMoney());
		expenditureEdited.setDescription(expenditure.getDescription());
		expenditureEdited.setDate(expenditure.getDate());
		expenditureEdited.setUser_id(expenditure.getUser_id());
		expenditureEdited.setCategory_id(expenditure.getCategory_id());
		return expenditureEdited;
	}

	public void deleteExpenditure(long id) {
		expenditureRepository.deleteById(id);
		
	}
	
	
	
	
}

