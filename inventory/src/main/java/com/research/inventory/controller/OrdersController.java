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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.research.inventory.model.Order;
import com.research.inventory.model.OrderStatus;
import com.research.inventory.serviceImpl.OrderServiceImpl;
import com.research.inventory.utils.BaseResponse;

/**
 * 
 * The class is having the rest services for create,edit,delete the order model.
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@RestController
@RequestMapping("/rest/order")
public class OrdersController {

	@Autowired
	OrderServiceImpl orderService;

	RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
			.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();

	/**
	 * The method is used for creating order object Takes a Order model object and
	 * output response 201 for saved and 500 for error
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PostMapping(path = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BaseResponse> create(@RequestBody Order order) {

		Boolean response = orderService.save(order);
		if (response == true) {
			return new ResponseEntity<BaseResponse>(new BaseResponse(true, "Created successfully"), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<BaseResponse>(new BaseResponse(true, "Unable to create"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * The method is used for updating order object Takes a existing Order model
	 * object and output response 201 for saved and 500 for error
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PostMapping("/edit")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> update(@RequestBody Order order) {
		Boolean response = orderService.update(order);
		if (response == true) {
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * The method is used for fetching order object Takes id of the object and
	 * output corresponding object if it exists or null if not present
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get/{id}")
	public Order get(@PathVariable Long id) {
		if (id != null) {
			Order response = orderService.get(id);
			return response;
		}
		return null;
	}

	/**
	 * The method is used for deleting order object Takes a existing Order model
	 * object and output response 201 for saved and 500 for error
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if (id != null) {
			Boolean response = orderService.delete(id);
			if (response == true) {
				return new ResponseEntity<String>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

	/**
	 * The method is used for fetching all order object Takes a nothing and output
	 * list of orders objects
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@GetMapping("/getall")
	public List<Order> getAll() {
		List<Order> orders = orderService.getAll();
		return orders;
	}

	/**
	 * The method is used for fetching all orders with given status nothing and
	 * output list of orders objects having given status
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@GetMapping("/getordersbystatus")
	public List<Order> getAllOutOfOrders(@RequestParam OrderStatus status) {
		List<Order> orders = orderService.getAllByStatus(status);
		return orders;
	}

}
