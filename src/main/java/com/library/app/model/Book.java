package com.library.app.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	private Long id;

	@Column(name = "isbn_no")
	private String isbnNo;

	@Column(name = "name")
	private String name;

	@Column(name = "sub_name")
	private String subName;

	@Column(name = "series_name")
	private String seriesName;

	@Column(name = "description")
	private String description;

	// @ManyToMany(targetEntity = Publisher.class, fetch = FetchType.LAZY)
	// @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name =
	// "book_id"), inverseJoinColumns = @JoinColumn(name = "publisher_id"))
	// private List<Publisher> publisherList= new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors = new ArrayList<>();

	@Column(name = "deleted")
	private Boolean deleted = false;
	
	@CreationTimestamp
	@Column(name="created_date")
	private Calendar createdDate;
	
	
	@UpdateTimestamp
	@Column(name="updated_date")
	private Calendar updatedDate;

	
	

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

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


	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
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
