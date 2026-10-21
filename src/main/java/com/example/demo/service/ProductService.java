package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public List<Product> searchProducts(String category) {

		if (category == null || category.isBlank()) {
			return productRepository.findAll();
		}

		return productRepository.findByCategoryContainingIgnoreCase(category);
	}

	public List<Product> filterByPrice(Double min, Double max) {

		if (min == null)
			min = 0.0;
		if (max == null)
			max = Double.MAX_VALUE;

		return productRepository.findByPriceBetween(min, max);
	}

	public List<Product> searchByName(String name) {

	    if(name == null || name.isBlank()) {
	        return productRepository.findAll();
	    }

	    return productRepository.findByNameContainingIgnoreCase(name);
	}
	
	public Product saveProduct(Product product) {

	    try {
	        return productRepository.save(product);
	    }
	    catch (Exception e) {
	        throw new RuntimeException("Product name already exists!");
	    }
	}
	
	public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

	public Product updateProduct(Long id, Product updatedProduct) {

        Product existingProduct =
                productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setPrice(updatedProduct.getPrice());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    
	
}