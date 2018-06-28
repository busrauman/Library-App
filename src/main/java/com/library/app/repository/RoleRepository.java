package com.library.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
