package com.cts.ebilling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ebilling.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 public User findByEmail(String email);

}
