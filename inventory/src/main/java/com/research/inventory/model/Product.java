package com.research.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**

* The class is the model for User Entity of the inventory.
* It have fields like title ,author ,ISBN ,publisher ,category,stock
* Author and Publisher are of user type ,
* category  is coming from the Enumeration bookCategory
* and stock is the quantity of books in stock

* @version 1.0

* @author Prateek T

*/
@Entity 
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String title ;
	 
	@ManyToOne
	private Seller seller ;
	
	@Column
	private String description ;
	 
	@Column
	private String serialNo ;
	 
	@Column
	private ProductCategory category ;
	
	@Column
	private String imageURL;
	@Column
	private Integer stockCount ;
	
	@Column 
	private Double rating;
	
	@Column
	private Double price;
	
	@Column
	private Boolean is_available;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIs_available() {
		return is_available;
	}

	public void setIs_available(Boolean is_available) {
		this.is_available = is_available;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", seller=" + seller + ", description=" + description
				+ ", serialNo=" + serialNo + ", category=" + category + ", imageURL=" + imageURL + ", stockCount="
				+ stockCount + ", rating=" + rating + ", price=" + price + ", is_available=" + is_available + "]";
	}

	 
}
