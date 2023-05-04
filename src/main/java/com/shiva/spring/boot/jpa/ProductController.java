package com.shiva.spring.boot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/viewProductById/{productId}")
	public Product viewProductById(@PathVariable int productId) {
		return service.viewProductById(productId);
	}

	@GetMapping("/viewProductByName/{name}")
	public Product viewProductByName(@PathVariable String name) {
		return service.viewProductByName(name);
	}

	@GetMapping("/viewAllProducts")
	public List<Product> viewAllProducts() {
		return service.viewAllProducts();
	}

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping("/updateProductPrice/{productId}/{price}")
	public Product updateProductPrice(@PathVariable int productId, @PathVariable float price) {
		return service.updateProductPrice(productId, price);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public Product deleteProduct(@PathVariable int productId) {
		return service.deleteProduct(productId);
	}
}
