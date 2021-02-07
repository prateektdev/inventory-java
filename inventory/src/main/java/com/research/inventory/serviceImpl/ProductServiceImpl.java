package com.research.inventory.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.inventory.model.Product;
import com.research.inventory.repository.ProductRepository;
import com.research.inventory.service.ProductService;

/**
 * 
 * The is the product Service implementation , Where We defined the methods which
 * are declared in the product service
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	/**
	 * The method is used for saving the product
	 * takes Product type Object and returns Boolean true if saved else false
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean save(Product product) {

		try {
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for fetching the user Entity
	 * takes product id and returns product object for it
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Product get(Long product_id) {
		try {
			Optional<Product> product = productRepository.findById(product_id);
			return product.get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The method is used for updating the user Entity
	 * takes product type Object and returns Boolean true if updated else false
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean update(Product product) {
		try {
			Optional<Product> productObject = productRepository.findById(product.getId());
			if (productObject != null) {
				productRepository.save(product);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for deleting the product Entity
	 * takes product id and delete Product for it
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean delete(Long product_id) {
		try {
			Optional<Product> productObject = productRepository.findById(product_id);
			if (productObject != null) {
				productRepository.deleteById(product_id);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for fetching products
	 * takes nothing and returns all products 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public List<Product> getAll() {
		try {
			List<Product> productObject = (List<Product>) productRepository.findAll();
			return productObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The method is used for fetching products objects having stock 0
	 * takes nothing and returns all products having stock 0
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public List<Product> getAllOutOfStock() {
		try {
			List<Product> productObject = (List<Product>) productRepository.findByStockCount(0);
			return productObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
