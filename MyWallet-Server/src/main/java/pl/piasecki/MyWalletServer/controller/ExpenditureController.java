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

import pl.piasecki.MyWalletServer.model.Expenditure;
import pl.piasecki.MyWalletServer.service.ExpenditureService;


@RestController
public class ExpenditureController {

	@Autowired
	private ExpenditureService expenditureService;
	
	@GetMapping("/expenditures")
	public List<Expenditure> getExpenditures()
	{
		return expenditureService.getExpenditures();
	}
	
	@GetMapping("/expenditures/{id}")
	public Expenditure getSingleExpenditure(@PathVariable long id)
	{
		return expenditureService.getExpenditure(id);
	}
	
	
	@PostMapping("/expenditures")
	public Expenditure addExpenditure(@RequestBody Expenditure expenditure)
	{
		return expenditureService.addExpenditure(expenditure);
	}
	
	@PutMapping("/expenditures")
	public Expenditure editExpenditure(@RequestBody Expenditure expenditure)
	{
		return expenditureService.editExpenditure(expenditure);
	}
	
	@DeleteMapping("/expenditures/{id}")
	public void deleteExpenditure(@PathVariable long id)
	{
		expenditureService.deleteExpenditure(id);
	}
}
