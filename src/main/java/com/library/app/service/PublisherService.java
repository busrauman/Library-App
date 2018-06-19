package com.library.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.model.Publisher;
import com.library.app.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	public Publisher getPublisher(Long id) {
		// TODO Auto-generated method stub
		return publisherRepository.getOne(id);
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

}
