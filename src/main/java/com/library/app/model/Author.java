package com.library.app.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="author_seq")
	@SequenceGenerator(
			name="author_seq",
			sequenceName="author_seq",
			allocationSize=1
			)	
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	private Long  id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Type(type="text")
	@Column(name="description")
	private String description;
	
	@Column(name="deleted")
	private Boolean deleted = false;
	
	@CreationTimestamp
	@Column(name="created_date")
	private Calendar createdDate;
	
	
	@UpdateTimestamp
	@Column(name="updated_date")
	private Calendar updatedDate;

	
	
	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		if(null != this.firstname && null != this.firstname ) {
			return this.firstname +" " + this.lastname;
		}
		return "";
	}
	
	
}
