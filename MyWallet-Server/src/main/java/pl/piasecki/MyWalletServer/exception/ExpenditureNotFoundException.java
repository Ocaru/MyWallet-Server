package pl.piasecki.MyWalletServer.exception;

public class ExpenditureNotFoundException extends RuntimeException {
	
	public ExpenditureNotFoundException(long id)
	{
		super("Could not find expenditure with id: " + id);
	}

}
