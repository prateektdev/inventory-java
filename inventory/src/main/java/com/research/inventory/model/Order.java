package com.research.inventory.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

/**

* The class is the model for Order Entity of the inventory.
* It have fields like amount , products, order_date, status

* @version 1.0

* @author Prateek T

*/
@Entity 
@Table(name="orders") 
public class Order {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String orderNumber ;
	 
	@ManyToOne
	private User orderBy ;
	  
	@Column 
	private Double amount;
	 
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;

	@Column
	private Date orderPlacedAt;
	
	@Column 
	private OrderStatus status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public User getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(User orderBy) {
		this.orderBy = orderBy;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getOrderPlacedAt() {
		return orderPlacedAt;
	}

	public void setOrderPlacedAt(Date orderPlacedAt) {
		this.orderPlacedAt = orderPlacedAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderBy=" + orderBy + ", amount=" + amount
				+ ", products=" + products + ", orderPlacedAt=" + orderPlacedAt + ", status=" + status + "]";
	}
}
