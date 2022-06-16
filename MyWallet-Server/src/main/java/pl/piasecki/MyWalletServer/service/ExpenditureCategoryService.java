package pl.piasecki.MyWalletServer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.piasecki.MyWalletServer.exception.ExpenditureCategoryNotFoundException;
import pl.piasecki.MyWalletServer.model.ExpenditureCategory;
import pl.piasecki.MyWalletServer.repository.ExpenditureCategoryRepository;

@Service
public class ExpenditureCategoryService {
	
	@Autowired
	private ExpenditureCategoryRepository expenditureCategoryRepository;
	
	public List<ExpenditureCategory> getExpenditureCategories()
	{
		return expenditureCategoryRepository.findAll();
	}
	
	public ExpenditureCategory getExpenditureCategory(long id)
	{
		return expenditureCategoryRepository.findById(id).orElseThrow(() -> new ExpenditureCategoryNotFoundException(id));
	}
	
	public ExpenditureCategory addExpenditureCategory(ExpenditureCategory expenditureCategory) {
		
		return expenditureCategoryRepository.save(expenditureCategory);
	}

	@Transactional
	public ExpenditureCategory editExpenditureCategory(ExpenditureCategory expenditureCategory)
	{
		ExpenditureCategory expenditureEdited = expenditureCategoryRepository.findById(expenditureCategory.getId()).orElseThrow();
		expenditureEdited.setName(expenditureCategory.getName());
		return expenditureEdited;
	}

	public void deleteExpenditureCategory(long id) {
		expenditureCategoryRepository.deleteById(id);
		
	}
	
}
