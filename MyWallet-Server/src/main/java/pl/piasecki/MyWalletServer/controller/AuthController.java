package pl.piasecki.MyWalletServer.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piasecki.MyWalletServer.configuration.springSecurityConfig.LoginDTO;

@RestController
public class AuthController  {


    @PostMapping("/login")
    public void authenticateUser(@RequestBody LoginDTO loginDTO){
    	
    }
    
}
