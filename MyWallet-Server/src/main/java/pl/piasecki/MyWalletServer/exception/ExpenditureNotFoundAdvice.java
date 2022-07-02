package pl.piasecki.MyWalletServer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExpenditureNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ExpenditureNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String expenditureNotFoundHandler(ExpenditureNotFoundException e) {
		return e.getMessage();
	}
	
}
