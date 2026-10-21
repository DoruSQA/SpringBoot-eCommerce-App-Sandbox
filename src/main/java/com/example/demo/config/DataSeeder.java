
package com.example.demo.config;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetails;
import com.example.demo.repository.ProductDetailsRepository;
import com.example.demo.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

	@Bean
	CommandLineRunner seedDatabase(ProductRepository productRepository,
			ProductDetailsRepository productDetailsRepository) {

		return args -> {

			// Avoid inserting seed data if products already exist.
			if (productRepository.count() > 0) {
				return;
			}

			seedProduct(productRepository, productDetailsRepository, "Laptop Lenovo IdeaPad", "Electronics", 2899.99,
					"15.6-inch laptop, 16 GB RAM, 512 GB SSD", 12);

			seedProduct(productRepository, productDetailsRepository, "Samsung Galaxy A56", "Smartphones", 1899.99,
					"Android smartphone with 256 GB storage", 8);

			seedProduct(productRepository, productDetailsRepository, "Logitech MX Master 3S", "Accessories", 499.99,
					"Wireless ergonomic mouse", 4);

			seedProduct(productRepository, productDetailsRepository, "Mechanical Keyboard K2", "Accessories", 349.99,
					"Mechanical keyboard with RGB lighting", 15);

			seedProduct(productRepository, productDetailsRepository, "LG UltraGear 27-inch", "Monitors", 1199.99,
					"27-inch gaming monitor, 144 Hz", 3);

			seedProduct(productRepository, productDetailsRepository, "Sony WH-1000XM5", "Audio", 1399.99,
					"Wireless noise-cancelling headphones", 6);

			seedProduct(productRepository, productDetailsRepository, "Samsung T7 SSD 1TB", "Storage", 449.99,
					"Portable external SSD, 1 TB", 20);

			seedProduct(productRepository, productDetailsRepository, "Logitech C920 HD Pro", "Accessories", 299.99,
					"Full HD webcam for video calls", 0);

			seedProduct(productRepository, productDetailsRepository, "JBL Flip 6", "Audio", 499.99,
					"Portable Bluetooth speaker", 2);

			seedProduct(productRepository, productDetailsRepository, "USB-C Hub 7-in-1", "Accessories", 129.99,
					"USB-C hub with HDMI and USB ports", 30);
		};
	}

	private void seedProduct(ProductRepository productRepository, ProductDetailsRepository productDetailsRepository,
			String name, String category, Double price, String details, Integer stock) {

		Product product = new Product();
		product.setName(name);
		product.setCategory(category);
		product.setPrice(price);

		Product savedProduct = productRepository.save(product);

		ProductDetails productDetails = new ProductDetails();
		productDetails.setDetails(details);
		productDetails.setStock(stock);
		productDetails.setProduct(savedProduct);

		productDetailsRepository.save(productDetails);
	}
}
