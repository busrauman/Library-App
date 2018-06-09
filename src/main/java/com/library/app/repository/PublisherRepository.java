package com.library.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.app.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{
	List<Publisher> findByDeletedFalse();
}
