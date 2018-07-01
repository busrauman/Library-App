package com.library.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.model.Book;
import com.library.app.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@PersistenceContext
	private EntityManager em;

	public Book getBook(Long id) {
		return bookRepository.getOne(id);
	}

	public void saveOrUpdate(Book book) {
		bookRepository.saveAndFlush(book);
	}

	public List<Book> books() {
		return bookRepository.findByDeletedFalse();
	}

	public List<Book> search(String search) {
		Criteria criteria = em.unwrap(Session.class).createCriteria(Book.class);
		criteria.add(Restrictions.or(Restrictions.like("name", 	search,MatchMode.ANYWHERE).ignoreCase(),
				Restrictions.like("isbnNo", search,MatchMode.ANYWHERE).ignoreCase()));
		return criteria.list();
	}

}
