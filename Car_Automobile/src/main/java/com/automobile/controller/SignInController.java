package com.automobile.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.automobile.model.Login;
import com.automobile.service.LoginService;

@Controller
@RequestMapping("/signin")
public class SignInController {
	@Autowired 
	private LoginService loginService;
		

	
		@PostMapping("/addLogin")
		public String login(@ModelAttribute("login") @Valid Login login, BindingResult br, Model model) {
			if (br.hasErrors()) {
				
				return "login-process";
			}
			
			boolean result = loginService.login(login);
			if(result) {
				model.addAttribute("success", "Able to login welcome back!");
				return "redirect:/";
			}else {
				model.addAttribute("error", "Unable to login email or password is incorret!");
				return "/login";
			}
		}

}
