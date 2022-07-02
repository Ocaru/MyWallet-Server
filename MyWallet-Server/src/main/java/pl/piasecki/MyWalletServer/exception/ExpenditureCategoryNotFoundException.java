package pl.piasecki.MyWalletServer.exception;

public class ExpenditureCategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExpenditureCategoryNotFoundException(long id) {
		super("Could not find expenditure with id: " + id);
	}

}
