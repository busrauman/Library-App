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

import com.library.app.model.Author;
import com.library.app.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public Author getAuthor(Long id) {
		return authorRepository.getOne(id);
	}

	public void saveOrUpdate(Author author) {
		authorRepository.saveAndFlush(author);
	}

	public List<Author> authors() {
		// TODO Auto-generated method stub
		return authorRepository.findByDeletedFalse();
	}
	public void deleteAuthor(Long id) {
		authorRepository.deleteAuthor(id);
	}

	public List<Author> search(String search) {
		Criteria criteria = em.unwrap(Session.class).createCriteria(Author.class);
		criteria.add(Restrictions.or(Restrictions.like("firstname", search,MatchMode.ANYWHERE).ignoreCase(),Restrictions.like("lastname", search,MatchMode.ANYWHERE).ignoreCase()));
		criteria.add(Restrictions.eq("deleted", false));
		return criteria.list();
	}

}
