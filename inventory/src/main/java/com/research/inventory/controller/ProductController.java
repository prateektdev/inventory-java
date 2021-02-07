package com.research.inventory.controller;

import java.util.List;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.inventory.model.Product;
import com.research.inventory.model.ProductCategory;
import com.research.inventory.model.User;
import com.research.inventory.repository.UserRepository;
import com.research.inventory.serviceImpl.ProductServiceImpl;
import com.research.inventory.serviceImpl.UserServiceImpl;
import com.research.inventory.utils.BaseResponse;

/**
 * 
 * The class is having the rest services for create,edit,delete the product
 * model.
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@RestController
@RequestMapping("/rest/product")
public class ProductController {

	@Autowired
	ProductServiceImpl productService;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserRepository userRepository;

	RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
			.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();

	/**
	 * The method is used for creating product object Takes a Product model object
	 * and output response 201 for saved and 500 for error
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PostMapping(path = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BaseResponse> create(@RequestBody Product product) {
		System.out.println("product : " + product.toString());
		product.setSerialNo(randomStringGenerator.generate(12));
		product.setCategory(ProductCategory.ELECTRONICS);
		Boolean response = productService.save(product);
		if (response == true) {
			return new ResponseEntity<BaseResponse>(new BaseResponse(true,"Created successfully"), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<BaseResponse>(new BaseResponse(true,"Unable to create"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * The method is used for updating product object Takes a existing Product model
	 * object and output response 201 for saved and 500 for error
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PostMapping("/edit")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> update(@RequestBody Product product) {
		Boolean response = productService.update(product);
		if (response == true) {
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * The method is used for fetching product object Takes id of the object and
	 * output corresponding object if it exists or null if not present
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get/{id}")
	public Product get(@PathVariable Long id) {
		if (id != null) {
			Product response = productService.get(id);
			return response;
		}
		return null;
	}

	/**
	 * The method is used for deleting product object Takes a existing Product model
	 * object and output response 201 for saved and 500 for error
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if (id != null) {
			Boolean response = productService.delete(id);
			if (response == true) {
				return new ResponseEntity<String>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

	/**
	 * The method is used for fetching all product object Takes a nothing and output
	 * list of products objects
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@GetMapping("/getall")
	public List<Product> getAll() {
		List<Product> products = productService.getAll();
		return products;
	}

	/**
	 * The method is used for fetching all product object out of stock Takes a
	 * nothing and output list of products objects having stock 0
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@GetMapping("/getcancelledOrders")
	public List<Product> getAllOutOfProducts() {
		List<Product> products = productService.getAllOutOfStock();
		return products;
	}

	/**
	 * The method is used for fetching all user objects Takes a nothing and output
	 * list of user objects having role USER
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@GetMapping("/getallusers")
	public List<User> getAllUsers() {
		return userService.getAll();
	}
}
