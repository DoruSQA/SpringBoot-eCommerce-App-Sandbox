package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();

	List<Product> findByCategoryContainingIgnoreCase(String category);

	List<Product> findByPriceBetween(Double min, Double max);
	
	List<Product> findByNameContainingIgnoreCase(String name);
	
	int findById(int id);
}
