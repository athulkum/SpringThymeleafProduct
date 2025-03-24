package com.codewithathul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewithathul.entity.Product;
import com.codewithathul.repo.ProductRepository;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	ProductRepository repository;
	

	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		Product product = new Product();
		
	 /*	product.setName("keyboard");
		product.setPrice(300.0);
		product.setQty(1);
		*/
		model.addAttribute("product", product);
		
		
		return "index";
	}
	
	@PostMapping("/save")
	public String handleSave(Product product ,Model model) {
       
	Product p =	repository.save(product);
	if(p.getId()!=null) {
		model.addAttribute("msg", "product saved");
	}
		
		return "index";
	}
	
}
