package com.codewithathul.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String handleSave(@Validated Product product, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "index";
		}
       
	Product p =	repository.save(product);
	if(p.getId()!=null) {
		model.addAttribute("msg", "product saved");
	}
		
		return "index";
	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {
		
		model.addAttribute("products", repository.findAll());
		
		return "products";
	}
	
	@GetMapping("/edit")
	public String updateProduct(@RequestParam ("id") Integer id, Model model) {
	
		Optional<Product> p= repository.findById(id);
		if(p.isPresent()) {
	       Product product = p.get();
			repository.save(product);
			model.addAttribute("product", product);
		}
	return "index";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id, Model model) {
		
	Optional< Product> p=	repository.findById(id);
	
	if(p.isPresent()){
		repository.deleteById(id);	
		
		model.addAttribute("msg", "delete Success");
		model.addAttribute("products", repository.findAll());
	}
	return "products";
	
	}
}