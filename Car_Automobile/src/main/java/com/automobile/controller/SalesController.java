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

import com.automobile.model.Sales;
import com.automobile.service.SaleService;

@Controller
@RequestMapping("/sales")
public class SalesController {
	
@Autowired 
private SaleService saleService;
	
	@RequestMapping("/sales")
	public String home(@ModelAttribute("sale") Sales sale, Model model) {
		List<Sales> sal = saleService.listAll();
		model.addAttribute("sal", sal);
		return "salesForm";
	}
	
	@PostMapping("/addSales")
	public String addSale(@ModelAttribute("sale") @Valid Sales sale, BindingResult br, Model model) {
		if (br.hasErrors()) {
			List<Sales> sal= saleService.listAll();
			model.addAttribute("sal", sal);
			return "salesForm";
		}
		
		List<Sales> sal= saleService.listAll();
		model.addAttribute("sal", sal);
		saleService.addSale(sale);
		return "salesForm";
	}
	
	@GetMapping("/deleteSales")
	public String deleteSales(@RequestParam int id) {
		saleService.removeSales(id);
		return "redirect:/";
	}

}
