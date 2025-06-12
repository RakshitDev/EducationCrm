package com.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sp.main.entities.User;
import com.sp.main.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.SessionStatus;




@Controller
public class UserController {

	@Autowired
	UserService userService; 

	@GetMapping({"/","/index"})
	public String openIndex() {
		return "index";
	}
	//----LoginStartsHere-----------          
	@GetMapping("/login")
	public String openLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/loginForm")
	public String handleLoginForm(@ModelAttribute("user") User user,Model model) {
		boolean isAuthenticated = userService.loginUserService(user.getEmail(), user.getPassword());
		if(isAuthenticated){
			return "user-profile";
		}else {
			model.addAttribute("errorMsg", "Incorrect Email or Password");
			return "login";
		}
	}
	//----LoginStartsHere-----------




	//------Register Starts----------
	@GetMapping("/register")
	public String openRegisterPage(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String handleRegForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		else
		{
			try
			{
				userService.registerUserService(user);
				
				model.addAttribute("successMsg", "Registered Successfully");
				return "register";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				model.addAttribute("errorMsg", "Registration Failed");
				return "error";
			}
		}
	}



	//------Register Ends----------

	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "login";
	}


}

//All the code here is for the reference only 

//@PostMapping("/regForm") firstCode
//public String handleRefForm(@ModelAttribute("user") User user, Model model) {
//	boolean status = userService.registerUserService(user);
//	if(status) {
//		model.addAttribute("successMsg", "Registered SuccessFully");
//		return "register";
//	}else {
//		model.addAttribute("errorMsg", "Registration Failed");
//		return "error";
//	}
//}
