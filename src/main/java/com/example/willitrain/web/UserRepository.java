package com.example.willitrain.web;


import org.springframework.data.repository.CrudRepository;

import com.example.willitrain.web.User;

public interface UserRepository extends CrudRepository<User, Long> {
	

	User findByUsername(String username);
}