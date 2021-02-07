package com.research.inventory.service;

import java.util.List;

import com.research.inventory.model.Order;
import com.research.inventory.model.OrderStatus;

/**
 * 
 * The is the Book Service interface , Where We declare the methods which We
 * will be calling in the Book Controller. The implementation of this interface
 * is in bookServiceImpl
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
public interface OrderService {

	public Boolean save(Order order);

	public Order get(Long order_id);

	public Boolean update(Order order);

	public Boolean delete(Long order_id);

	public List<Order> getAll();

	public List<Order> getAllByStatus(OrderStatus status);
}
