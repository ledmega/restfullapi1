package com.example.sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sample.data.entity.ComUser;

public interface UserRepository extends CrudRepository<ComUser, Long> {
	
	//List<User> findByEmail(String email);

}
