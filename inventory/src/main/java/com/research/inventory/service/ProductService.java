package com.research.inventory.service;

import java.util.List;

import com.research.inventory.model.Product;

/**

* The is the Book Service interface ,
* Where We declare the methods which We will be calling in the Book Controller.
* The implementation of this interface is in bookServiceImpl

* @version 1.0

* @author Prateek T

*/
public interface ProductService {

	public Boolean save(Product book);

	public Product get(Long book_id);

	public Boolean update(Product book);

	public Boolean delete(Long book_id);

	public List<Product> getAll();
	
	public List<Product> getAllOutOfStock();
}
