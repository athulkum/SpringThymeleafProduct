package com.codewithathul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "productform")
public class Product {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank (message = "Name cannot be blank")
	@Size (min=3, max = 15, message = "Name should be min 4 and max 15")
	private String name;
	
	@NotNull(message = "Price cannot be empty")
	@Positive (message = "price value should be positive")
	private Double price;
	
	@NotNull(message = "Quantity cannot be empty")
	@Positive(message = "Quantity Should be positive")
	private Integer qty;
	
}