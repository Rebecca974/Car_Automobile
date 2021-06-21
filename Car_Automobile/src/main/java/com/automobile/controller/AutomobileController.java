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
import org.springframework.web.servlet.ModelAndView;

import com.automobile.model.Cars;
import com.automobile.model.Customer;
import com.automobile.model.Login;
import com.automobile.model.Product;
import com.automobile.model.Sales;
import com.automobile.model.Signup;
import com.automobile.service.CarService;
import com.automobile.service.CustomerService;
import com.automobile.service.LoginService;
import com.automobile.service.PaymentService;
import com.automobile.service.SaleService;
import com.automobile.service.SignUpService;

@Controller
public class AutomobileController {

	
	

	@Autowired 
	private CustomerService customerService;
	
	@Autowired 
	private SaleService saleService;
	
	@Autowired 
	private CarService carService;
	
	@Autowired 
	private LoginService loginService;
	

	@GetMapping("/product-input-form")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	
	//show login form
	@GetMapping("/login")
	public ModelAndView displayLoginPage(@ModelAttribute("login") Login login, BindingResult errors) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView displayLogoutPage(@ModelAttribute("logout") Login login, BindingResult errors) {
		ModelAndView mav = new ModelAndView("welcomepage");
		return mav;
	}
	@PostMapping("/login-process")
	public ModelAndView processForm(@ModelAttribute("login") @Valid Login l,  BindingResult errors)
	{
		if(errors.hasErrors())
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		ModelAndView mav = new ModelAndView("userpage");
		return mav;
	}
	
	////////signUp Page
	@GetMapping("/signup")
	public ModelAndView displaySignUpPage(@ModelAttribute("signup") Signup signup, BindingResult errors) {
		ModelAndView mav = new ModelAndView("signup");
		return mav;
	}
	
	@PostMapping("/signup-process")
	public ModelAndView processSignUp(@ModelAttribute("signup") @Valid Signup signup,  BindingResult errors)
	{
		if(errors.hasErrors())
		{
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		}
		ModelAndView mav = new ModelAndView("signupConfirmed");
		return mav;
	}
	 //customer
	
	@RequestMapping("/customer")
	public String form2(@ModelAttribute("customer") Customer customer, Model model) {
		List<Customer> custom = customerService.listAll();
		model.addAttribute("custom", custom);
		return "customerForm";
	}
	

	// carsSale information	
	
	@RequestMapping("/car")
	public String home(@ModelAttribute("car") Cars car, Model model) {
		List<Cars> cas = carService.listAll();
		model.addAttribute("cas", cas);
		return "carForm";
	}

// sales information	
	
	@RequestMapping("/sales")
	public String home(@ModelAttribute("sale") Sales sale, Model model) {
		List<Sales> sal = saleService.listAll();
		model.addAttribute("sal", sal);
		return "salesForm";
	}
	

	
	// payment information	

  @PostMapping("/addLogin")
	public String login(@ModelAttribute("login") @Valid Login login, BindingResult br, Model model) {
		if (br.hasErrors()) {
			
			return "login-process";
		}
		System.out.println(login.toString());
		boolean result = loginService.login(login);
		System.out.println(result);
		if(result) {
			model.addAttribute("success", " login succefully!");
			return "/index";
		}else {
			model.addAttribute("error", "Unable to login!");
			return "/login";
		}
	}
}
