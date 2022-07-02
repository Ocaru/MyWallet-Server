package pl.piasecki.MyWalletServer.exception;

public class ExpenditureNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExpenditureNotFoundException(long id) {
		super("Could not find expenditure with id: " + id);
	}

}
