package com.research.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification {

	@Id
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;
	
	@Column
	private NotificationStatus status;
	
	@Column
	private Date notificationTime;
	
}
