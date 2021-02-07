package com.research.inventory.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.inventory.model.Order;
import com.research.inventory.model.OrderStatus;
import com.research.inventory.repository.OrderRepository;
import com.research.inventory.service.OrderService;

/**
 * 
 * The is the order Service implementation , Where We defined the methods which
 * are declared in the order service
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	/**
	 * The method is used for saving the order
	 * takes Order type Object and returns Boolean true if saved else false
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean save(Order order) {

		try {
			orderRepository.save(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for fetching the order Entity
	 * takes order id and returns order object for it
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Order get(Long order_id) {
		try {
			Optional<Order> order = orderRepository.findById(order_id);
			return order.get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The method is used for updating the user Entity
	 * takes order type Object and returns Boolean true if updated else false
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean update(Order order) {
		try {
			Optional<Order> orderObject = orderRepository.findById(order.getId());
			if (orderObject != null) {
				orderRepository.save(order);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for deleting the order Entity
	 * takes order id and delete Order for it
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean delete(Long order_id) {
		try {
			Optional<Order> orderObject = orderRepository.findById(order_id);
			if (orderObject != null) {
				orderRepository.deleteById(order_id);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for fetching orders
	 * takes nothing and returns all orders 
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public List<Order> getAll() {
		try {
			List<Order> orderObject = (List<Order>) orderRepository.findAll();
			return orderObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The method is used for fetching orders objects having status 
	 * by given status
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public List<Order> getAllByStatus(OrderStatus status) {
		try {
			List<Order> orderObject = (List<Order>) orderRepository.findByStatus(status);
			return orderObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
