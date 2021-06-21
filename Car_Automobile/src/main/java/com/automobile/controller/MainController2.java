package com.automobile.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.automobile.model.Payment;
import com.automobile.model.Product;
import com.automobile.service.PaymentService;
@Controller
@RequestMapping("/product-input-form")
public class MainController2 {

	@Autowired 
	private PaymentService payService;

	@GetMapping("/product-input-form")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	@PostMapping("/save-product")
	public String fileUpload(@RequestParam("images") MultipartFile [] files,
			Model model, Product product, RedirectAttributes redirect) throws IOException {

		
		String uploadDir ="C:\\Users\\rebec\\git1\\Car_Automobile\\Car_Automobile\\src\\main\\webapp\\fileuploads";
		
		for (MultipartFile file: files) {
			if (!file.getOriginalFilename().isEmpty()) {
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(
								new File(uploadDir, file.getOriginalFilename())));
				outputStream.write(file.getBytes());
				outputStream.flush();
				outputStream.close();
				System.out.println("uploaded " + file.getOriginalFilename());
			} else {
				redirect.addFlashAttribute("msg", "Please select at least one file...");
				return "redirect:/product-input-form";
			}
		}
		model.addAttribute("msg", "Multiple files uploaded successfully.");
		model.addAttribute("product", product);
		return "viewProductDetail";
	}
	
	@GetMapping("/paymentform")
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
		return "redirect:/";
	}
	
	@GetMapping("/deletePayment")
	public String deletePaymeny(@RequestParam int id) {
		payService.removePayment(id);
		return "redirect:/";
	}

}
