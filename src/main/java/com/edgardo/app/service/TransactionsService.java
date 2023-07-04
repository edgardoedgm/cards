package com.edgardo.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edgardo.app.entity.Transactions;

public interface TransactionsService {
	
	
	public Iterable <Transactions> findAll();
	public Page<Transactions> findAll(Pageable pageable);
	public Optional<Transactions> findById(Long id);
	public Transactions save(Transactions transactions);
	public void deleById(Long id);

}
