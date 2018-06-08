package com.library.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="publisher")
public class Publisher {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="publisher_seq")
	@SequenceGenerator(
			name="publisher_seq",
			sequenceName="publisher_seq",
			allocationSize=1
			)	
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	private Long  id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="deleted")
	private Boolean deleted = false;
	
	

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
