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
import com.library.app.model.Publisher;
import com.library.app.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public Publisher getPublisher(Long id) {
		// TODO Auto-generated method stub
		return publisherRepository.findByIdAndDeletedIsFalse(id);
	}

	public List<Publisher> findAll() {
		// TODO Auto-generated method stub
		return publisherRepository.findByDeletedFalse();
	}

	public void saveOrUpdate(Publisher publisher) {
		publisherRepository.saveAndFlush(publisher);
	}
	
	public void delete(Publisher publisher) {
		publisherRepository.deletePublisher(publisher.getId());
	}

	public List<Publisher> search(String search) {
		Criteria criteria = em.unwrap(Session.class).createCriteria(Publisher.class);
		criteria.add(Restrictions.like("name", search,MatchMode.ANYWHERE).ignoreCase());
		criteria.add(Restrictions.eq("deleted", false));
		return criteria.list();
		
	}

}
