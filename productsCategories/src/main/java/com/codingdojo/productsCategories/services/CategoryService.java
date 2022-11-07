package com.codingdojo.productsCategories.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.repositories.CategoryRepository;
@Service

public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategorys(){
		return categoryRepository.findAll();
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	public List<Category> getAssignedProducts(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedProducts(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}

	public Category singleCategory(Long id) {
		Optional<Category> optCat = categoryRepository.findById(id);
		if(optCat.isPresent()) {
			return optCat.get();
		}else {
			return null;
		}
	}
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	 public void deleteCategory(Long id) {
		 categoryRepository.deleteById(id);
	    }
	
}
