package com.codingdojo.productsCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsCategories.models.Category;
import com.codingdojo.productsCategories.models.Product;
import com.codingdojo.productsCategories.services.CategoryService;
import com.codingdojo.productsCategories.services.ProductService;
@Controller
public class HomeController {
	private final CategoryService categoryService;
	private final ProductService productService;
	// ================== CONSTRUCTOR ==================
	public HomeController(CategoryService categoryService, ProductService productService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	// ================== GENERAL ==================
		@RequestMapping("")
		public String index(Model model) {
			model.addAttribute("cats", categoryService.allCategorys());
			model.addAttribute("pros", productService.allProducts());
			return "index.jsp";
			
		}
		@GetMapping("/categorys/addpage")
		public String addCategory(Model model,@ModelAttribute("category") Category category) {
			return "addCategory.jsp";
		}
		
		@PostMapping("/api/add/category")
		public String handleaddCategory(Model model,@Valid @ModelAttribute("category") Category category,BindingResult result) {
			if(result.hasErrors()) {
				return "addCategory.jsp";
			}else {
				categoryService.addCategory(category);
				return "redirect:/categorys/addpage";
			}
		}
		
		@GetMapping("/products/addpage")
		public String addProduct(Model model,@ModelAttribute("product") Product product) {
			return "addProduct.jsp";
		}
		
		@PostMapping("/api/add/product")
		public String handleaddProduct(Model model,@Valid @ModelAttribute("product") Product product ,BindingResult result) {
			if(result.hasErrors()) {
				return "addProduct.jsp";
			}else {
				productService.addProduct(product);
				return "redirect:/products/addpage";
			}
		}
		
		@GetMapping("/products/{id}")
		public String showProduct(@PathVariable("id") Long id, Model model) {
			Product product = productService.singleProduct(id);
			model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
			model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
			model.addAttribute("product", product);
			return "show_product.jsp";
		}
		
	
		@PostMapping("/products/{id}")
		public String editProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
			Product product = productService.singleProduct(id);
			Category category = categoryService.singleCategory(catId);
			product.getCategories().add(category);
			productService.saveProduct(product);
			model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
			model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
			return "redirect:/products/" + id;
		}
		@DeleteMapping("/product/delete/{id}")
		 public String destroy(@PathVariable("id") Long id) {
			productService.deleteProduct(id);
	        return "redirect:/";
		}
		@GetMapping("/category/{id}")
		public String showCategory(@PathVariable("id") Long id, Model model) {
			Category category = categoryService.singleCategory(id);
			model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
			model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
			model.addAttribute("category", category);
			return "show_category.jsp";
		}
		@PostMapping("/category/{id}")
		public String editCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long proId,  Model model) {
			Product product = productService.singleProduct(proId);
			Category category = categoryService.singleCategory(id);
			category.getProducts().add(product);
			categoryService.saveCategory(category);
			model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
			model.addAttribute("unassignedCategories", productService.getUnassignedCategories(category));
			return "redirect:/category/" + id;
		}
		@DeleteMapping("/category/delete/{id}")
		 public String destroyy(@PathVariable("id") Long id) {
			categoryService.deleteCategory(id);
	        return "redirect:/";
		}
		
}
