package pl.piasecki.MyWalletServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@Autowired
	final ExpenditureController expenditureController;
	final UserController userController;

	public HomeController(ExpenditureController expenditureController, UserController userController) {
		this.expenditureController = expenditureController;
		this.userController = userController;
	}

}
