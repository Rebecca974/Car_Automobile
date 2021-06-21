package com.automobile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@GetMapping("/")
	public ModelAndView displayHomePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("welcomepage");
		return mav;
	}
	
	@GetMapping("/index")
	public ModelAndView displayTypesOfCar(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	
	@GetMapping("/aboutUs")
	public ModelAndView displayAboutUs(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("aboutUs");
		return mav;
	}

}
