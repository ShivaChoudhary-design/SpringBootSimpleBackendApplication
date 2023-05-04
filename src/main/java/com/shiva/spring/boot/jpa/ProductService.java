package com.shiva.spring.boot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product viewProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> p = productRepository.findById(productId);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}

	}

	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);

	}

	public Product updateProductPrice(int productId, float price) {
		// TODO Auto-generated method stub
		Optional<Product> p = productRepository.findById(productId);
		if (p.isPresent()) {
			Product product = p.get();
			product.setPrice(price);
			productRepository.save(product);
			return product;
		} else {
			return null;
		}
	}

	public Product deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product p = productRepository.findById(productId).orElse(null);
		productRepository.deleteById(productId);
		return p;

	}

	public Product viewProductByName(String name) {
		
		return productRepository.findByName(name);
	}

}
