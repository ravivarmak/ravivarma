package ravi.varma.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class LoginController {
	
	@GetMapping("/logins")
	public String login(){
		return "Welcome to Spring Boot Azure AD Open Connect O Auth";
	}
	@GetMapping("/welcome")
	public String welcome(Principal princip){
		System.out.println(princip.getName());		
		return "Welcome";
	}
}
