package com.research.inventory.utils;

import org.springframework.web.multipart.MultipartFile;

import com.research.inventory.model.Product;
import com.research.inventory.model.User;

public class BaseRequest {
	
	private MultipartFile image;
	private User user;
	private Product product;

	public MultipartFile getImage() {
		return image;
	}
 

	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "BaseRequest [image=" + image + ", user=" + user + ", product=" + product + "]";
	}
  
}
