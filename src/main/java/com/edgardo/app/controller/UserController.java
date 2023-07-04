package com.edgardo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.edgardo.app.entity.User;
import com.edgardo.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	// Create new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	// Read an user

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
		Optional<User> oUser = userService.findById(userId);

		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);

	}

	// update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userdetails, @PathVariable(value = "id") Long userId) {
		Optional<User> user = userService.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.get().setName(userdetails.getName());
		user.get().setSurname(userdetails.getSurname());
		user.get().setEmail(userdetails.getEmail());
		user.get().setEnabled(userdetails.getEnabled());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

	}

	// Delete an user
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {

		if (!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleById(userId);
		return ResponseEntity.ok().build();

	}

	// read all users

	@GetMapping
	public List<User> readAll() {

		List<User> users = StreamSupport.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return users;

	}

}
