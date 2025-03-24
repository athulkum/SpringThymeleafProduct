package com.codewithathul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Integer qty;
	
}
