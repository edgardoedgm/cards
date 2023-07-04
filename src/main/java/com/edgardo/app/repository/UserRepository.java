package com.edgardo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgardo.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

	

}
