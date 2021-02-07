package com.research.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seller {

	@Id
	private Integer id;

	@Column
	private String title;

	@Column
	private String about;

	@ManyToOne
	private User details;

	@Column
	private Double rating;

	@Column
	private Boolean is_approved;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public User getDetails() {
		return details;
	}

	public void setDetails(User details) {
		this.details = details;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Boolean getIs_approved() {
		return is_approved;
	}

	public void setIs_approved(Boolean is_approved) {
		this.is_approved = is_approved;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", title=" + title + ", about=" + about + ", details=" + details + ", rating="
				+ rating + ", is_approved=" + is_approved + "]";
	}

}
