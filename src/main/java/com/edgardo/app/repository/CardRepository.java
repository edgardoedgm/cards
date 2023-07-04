package com.edgardo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgardo.app.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	Optional<Card> findByNumber(String number);

	void deleteByNumber(String number);

}
