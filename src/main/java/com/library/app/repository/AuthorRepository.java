package com.library.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.app.model.Author;
import com.library.app.model.Publisher;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	List<Author> findByDeletedFalse();
	Author findByIdAndDeletedIsFalse(Long id);
	@Transactional
	@Modifying
	@Query("update Author p set p.deleted=true where p.id=:id")
	void deleteAuthor(@Param("id") Long id);
}
