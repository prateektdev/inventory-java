package com.research.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.research.inventory.model.Product;
import com.research.inventory.model.ProductCategory;
import com.research.inventory.model.Seller;

/**

* The is the JPA Repository for the Book Entity .
* We define the necessary methods which We will be implementing in the Book Service

* @version 1.0

* @author Prateek T

*/
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>  {

	public List<Product> findByTitle(String title);
	public List<Product> findBySeller(Seller seller);
	public List<Product> findBySerialNo(String serial_no); 
	public List<Product> findByCategory(ProductCategory category); 
	public List<Product> findByStockCount(Integer count);
}
