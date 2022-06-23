package pl.piasecki.MyWalletServer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ExpenditureCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name ="category_id", updatable = false, insertable = false) 
	private List<Expenditure> expenditureList;
	
	public ExpenditureCategory()
	{
		
	}
	
	public ExpenditureCategory(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<Expenditure> getExpenditureList() {
		return expenditureList;
	}

	public void setExpenditureList(List<Expenditure> expenditureList) {
		this.expenditureList = expenditureList;
	}

	@Override
	public String toString() {
		return "ExpenditureCategory [id=" + id + ", name=" + name + ", expenditureList=" + expenditureList + "]";
	}



}
