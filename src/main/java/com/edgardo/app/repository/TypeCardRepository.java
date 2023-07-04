package com.edgardo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgardo.app.entity.TypeCard;

@Repository
public interface TypeCardRepository extends JpaRepository<TypeCard, Long> {

}
