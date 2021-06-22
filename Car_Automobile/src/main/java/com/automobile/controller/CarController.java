package com.automobile.controller;

import java.util.List;

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

import com.automobile.model.Cars;
import com.automobile.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired 
	private CarService carService;
	
	@RequestMapping("/car")
	public String home(@ModelAttribute("car") Cars car, Model model) {
		List<Cars> cas = carService.listAll();
		model.addAttribute("cas", cas);
		return "carForm";
	}
	
	@PostMapping("/addCar")
	public String addCar(@ModelAttribute("car") @Valid Cars car, BindingResult br, Model model) {
		if (br.hasErrors()) {
		List<Cars> cas= carService.listAll();
			model.addAttribute("cas", cas);
			return "carForm";
		}
		
		List<Cars> cas= carService.listAll();
		model.addAttribute("cas", cas);
		carService.addCar(car);
		return "carForm";
	}
	
	@GetMapping("/deleteCars")
	public String deleteCars(@RequestParam int id) {
		carService.removeCar(id);
	return "redirect:/";
	}
	

}
