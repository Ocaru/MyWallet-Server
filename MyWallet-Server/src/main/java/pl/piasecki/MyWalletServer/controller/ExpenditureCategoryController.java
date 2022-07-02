package pl.piasecki.MyWalletServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piasecki.MyWalletServer.model.ExpenditureCategory;
import pl.piasecki.MyWalletServer.service.ExpenditureCategoryService;

@RestController
public class ExpenditureCategoryController {

	@Autowired
	private ExpenditureCategoryService expenditureCategoryService;

	@GetMapping("/expenditureCategories")
	public List<ExpenditureCategory> getExpenditureCategories() {
		return expenditureCategoryService.getExpenditureCategories();
	}

	@GetMapping("/expenditureCategories/{id}")
	public ExpenditureCategory getExpenditureCategory(@PathVariable long id) {
		return expenditureCategoryService.getExpenditureCategory(id);
	}

	@PostMapping("/expenditureCategories")
	public ExpenditureCategory addExpenditureCategory(@RequestBody ExpenditureCategory expenditureCategory) {
		return expenditureCategoryService.addExpenditureCategory(expenditureCategory);
	}

	@PutMapping("/expenditureCategories")
	public ExpenditureCategory editExpenditureCategory(@RequestBody ExpenditureCategory expenditureCategory) {
		return expenditureCategoryService.editExpenditureCategory(expenditureCategory);
	}

	@DeleteMapping("/expenditureCategories/{id}")
	public void deleteExpenditure(@PathVariable long id) {
		expenditureCategoryService.deleteExpenditureCategory(id);
	}
	
}
