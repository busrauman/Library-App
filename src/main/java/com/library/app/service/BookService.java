package com.library.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.model.Book;
import com.library.app.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book getBook(Long id) {
		return bookRepository.getOne(id);
	}

	public void saveOrUpdate(Book book) {
		bookRepository.saveAndFlush(book);
	}

	public List<Book> books() {
		return bookRepository.findByDeletedFalse();
	}

}
