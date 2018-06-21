package com.library.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.model.Author;
import com.library.app.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	

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

}
