package com.codewithathul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithathul.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}