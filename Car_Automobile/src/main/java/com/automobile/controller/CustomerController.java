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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.automobile.model.Customer;
import com.automobile.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public String form2(@ModelAttribute("customer") Customer customer, Model model) {
		List<Customer> custom = customerService.listAll();
		model.addAttribute("custom", custom);
		return "customerForm";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult br, Model model) {
		if (br.hasErrors()) {
			List<Customer> custom= customerService.listAll();
			model.addAttribute("custom", custom);
			return "customerForm";
		}
		List<Customer> custom= customerService.listAll();
		model.addAttribute("custom", custom);
		customerService.addCustomer(customer);
		return "customerForm";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam int id) {
		customerService.removeCustomer(id);
		return "redirect:/";
}

}
