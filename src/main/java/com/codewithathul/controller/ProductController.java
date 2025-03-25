package com.codewithathul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewithathul.entity.Product;
import com.codewithathul.repo.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		Product product = new Product();
//		product.setName("hdd");
//		product.setPrice(499.0);
//		product.setQty(2);
		
		model.addAttribute("product", product);
		
		return "index";
	}
	
	@PostMapping("/save")
	public String saveProduct(@Validated Product product,  BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "index";
		}
		System.out.println(product);
		Product p = repository.save(product);
		if(p.getId()!=null) {
			model.addAttribute("msg", "Product Saved");
		}
		return "index";
	}
	
	@GetMapping("/products")
	public String getAllProducts(Model model) {
		
		model.addAttribute("products", repository.findAll());
		
		return "products";
	}

}
