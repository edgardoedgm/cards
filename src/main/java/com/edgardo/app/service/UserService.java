package com.edgardo.app.service;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edgardo.app.entity.User;

public interface UserService {
	
	public Iterable <User> findAll();
	public Page<User> findAll(Pageable pageable);
	public Optional<User> findById(Long id);
	public User save(User user);
	public void deleById(Long id);
	
}
