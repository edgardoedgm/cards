package com.edgardo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgardo.app.entity.Card;
import com.edgardo.app.entity.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

}
