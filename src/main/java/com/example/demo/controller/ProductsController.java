package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetails;
import com.example.demo.repository.ProductDetailsRepository;
import com.example.demo.service.ProductService;

@Controller

public class ProductsController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	@GetMapping("/products")
	public String products() {
		return "products";
	}

	@GetMapping("/get-products")
	@ResponseBody
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/search-products")
	@ResponseBody
	public List<Product> searchProducts(@RequestParam String category) {

		return productService.searchProducts(category);
	}

	@GetMapping("/filter-products")
	@ResponseBody
	public List<Product> filterProducts(@RequestParam(required = false) Double min,
			@RequestParam(required = false) Double max) {

		return productService.filterByPrice(min, max);
	}

	@GetMapping("/search-by-name")
	@ResponseBody
	public List<Product> searchByName(@RequestParam String name) {
		return productService.searchByName(name);
	}

	@GetMapping("/add-new-product")
	public String addProductPage() {
		return "add-product";
	}

//	@PostMapping("/products")
//	@ResponseBody
//	public Product addProduct(@RequestBody Product product) {
//	    return productService.saveProduct(product);
//	}

	@PostMapping("/products")
	@ResponseBody
	public ResponseEntity<?> addProduct(@RequestBody Product product) {

		try {
			return ResponseEntity.ok(productService.saveProduct(product));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Product name already exists!");
		}
	}

	@GetMapping("/edit-product/{id}")
	public String editProductPage(@PathVariable Long id, Model model) {

		model.addAttribute("productId", id);

		return "edit-product";
	}
	
	@GetMapping("/products/{id}")
	@ResponseBody
	public Product getProductById(
	        @PathVariable Long id) {

	    return productService.getProductById(id);
	}
	
	
	@PutMapping("/products/{id}")
	@ResponseBody
	public Product updateProduct(
	        @PathVariable Long id,
	        @RequestBody Product product) {

	    return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/products/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteProduct(
	        @PathVariable Long id) {

	    productService.deleteProduct(id);

	    return ResponseEntity.ok("Product deleted successfully");
	}
	
	@GetMapping("/cart")
	public String cartPage(){
	    return "cart";
	}
	
	
	
	@PostMapping("/checkout")
	@ResponseBody
	public String checkout(@RequestBody List<Long> productIds) {

	    for(Long productId : productIds){

	        ProductDetails details =
	            productDetailsRepository.findByProductId(productId);

	        if(details == null){
	            throw new RuntimeException("No details for product " + productId);
	        }

	        if(details.getStock() <= 0){
	            throw new RuntimeException("Out of stock product id: " + productId);
	        }

	        details.setStock(details.getStock() - 1);
	        productDetailsRepository.save(details);
	    }

	    return "Purchase completed successfully!";
	}

}
