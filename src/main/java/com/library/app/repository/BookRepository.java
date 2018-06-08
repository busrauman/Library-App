package com.library.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByDeletedFalse();
}
