package com.automobile.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.automobile.model.Login;
import com.automobile.model.Signup;
import com.automobile.service.SignUpService;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	
@Autowired 
private SignUpService signUpService;
	

@GetMapping("/index")
public ModelAndView displayTypesOfCar(HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("index");
	return mav;
}

@GetMapping("/loginform")
public ModelAndView displayLoginPage(@ModelAttribute("login") Login login, BindingResult errors) {
	ModelAndView mav = new ModelAndView("login");
	return mav;
}
@GetMapping("/signup")
public String SignUp(@ModelAttribute("signup") Signup signup, Model model) {
	List<Signup> signs = signUpService.listAll();
	model.addAttribute("signs", signs);
	return "signup";
}


@PostMapping("/addSignUp")
public String addSignUp(@ModelAttribute("signup") @Valid Signup signup, BindingResult br, Model model) {
	if (br.hasErrors()) {
		List<Signup> signs= signUpService.listAll();
		model.addAttribute("signs", signs);
		
		return "signup";
	}
	signUpService.addSignUp(signup);
	return "signupConfirmed";
}

@GetMapping("/deleteSignup")
public String deleteSignUp(@RequestParam int id) {
	signUpService.removeSignUp(id);
	return "redirect:/";
}






}