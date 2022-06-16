package pl.piasecki.MyWalletServer.exception;

public class ExpenditureCategoryNotFoundException extends RuntimeException {
	
	public ExpenditureCategoryNotFoundException(long id)
	{
		super("Could not find expenditure with id: " + id);
	}

}
