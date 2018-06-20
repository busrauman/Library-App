package com.library.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.app.model.Publisher;
import java.lang.Long;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{
	List<Publisher> findByDeletedFalse();
	Publisher findByIdAndDeletedIsFalse(Long id);
	
	@Transactional
	@Modifying
	@Query("update Publisher p set p.deleted=true where p.id=:id")
	void deletePublisher(@Param("id") Long id);
}
