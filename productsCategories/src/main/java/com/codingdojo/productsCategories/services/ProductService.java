package com.codingdojo.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.repositories.ProductRepository;

@Service

public class ProductService {
	//constructor
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// retreive all products
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	// add product
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	// retreive single product
	public Product singleProduct(Long id) {
		Optional<Product> optPro = productRepository.findById(id);;
		if(optPro.isPresent()) {
			return optPro.get();
		}else {
			return null;
		}
	}
	public List<Product> getAssignedCategories(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedCategories(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	 public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
	    }
}
