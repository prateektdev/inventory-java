package com.research.inventory.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.research.inventory.model.Order;
import com.research.inventory.model.OrderStatus;
import com.research.inventory.model.User;

/**
 * 
 * The is the JPA Repository for the Book Entity . We define the necessary
 * methods which We will be implementing in the Book Service
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	public List<Order> findByOrderBy(User user);
	public Order findByOrOrderNumber(String orderNumber);
	public List<Order> findByStatus(OrderStatus status);
	public List<Order> findByOrderPlacedAt(Date date);
}
