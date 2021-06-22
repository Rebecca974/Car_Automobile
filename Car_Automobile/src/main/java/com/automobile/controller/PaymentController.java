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

import com.automobile.model.Payment;
import com.automobile.service.PaymentService;


@Controller
@RequestMapping("/payment")
public class PaymentController {
	
@Autowired 
private PaymentService payService;
	
	@GetMapping("/paymentForm")
	public String home(@ModelAttribute("payment") Payment payment, Model model) {
		List<Payment> paym = payService.listAll();
		model.addAttribute("paym", paym);
		return "paymentForm";
	}
	
	@PostMapping("/addPayment")
	public String addPayment(@ModelAttribute("payment") @Valid Payment payment, BindingResult br, Model model) {
		if (br.hasErrors()) {
			List<Payment> paym= payService.listAll();
			model.addAttribute("paym", paym);
			return "paymentForm";
		}
		payService.addPayment(payment);
		return "paymentForm";
	}
	
	@GetMapping("/deletePayment")
	public String deletePaymeny(@RequestParam int id) {
		payService.removePayment(id);
		return "redirect:/";
	}

}
