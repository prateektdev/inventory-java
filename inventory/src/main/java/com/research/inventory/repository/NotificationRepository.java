package com.research.inventory.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.research.inventory.model.Notification;
import com.research.inventory.model.NotificationStatus;
import com.research.inventory.model.Order;
import com.research.inventory.model.Product;

/**
 * 
 * The is the JPA Repository for the Notification Entity . We define the necessary
 * methods which We will be implementing in the Notification Service
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

	public List<Notification> findByOrder(Order order);

	public List<Notification> findByProduct(Product product);

	public List<Notification> findByNotificationTime(Date date);

	public List<Notification> findByStatus(NotificationStatus status);
}
