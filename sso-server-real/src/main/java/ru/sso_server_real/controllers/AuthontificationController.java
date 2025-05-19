package ru.sso_server_real.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.sso_server_real.AuthUser;
import ru.sso_server_real.service.UserService;

import javax.validation.Valid;

@Controller
public class AuthontificationController{
	
	@Autowired
	public UserService us;
	
	@GetMapping("/")
	public String authorisation() {
		return "greeting";
	}

	@GetMapping("/registration")
	public String registrationPage(Model model) {
		return "registration";
	}
	
	@GetMapping("/login")
	public String authontification() {
		return "authontification";
	}
}

//http://localhost:8080/registration
//http://localhost:8080/post-login