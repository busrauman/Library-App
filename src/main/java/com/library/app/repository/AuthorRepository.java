package com.library.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.app.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	List<Author> findByDeletedFalse();
}
