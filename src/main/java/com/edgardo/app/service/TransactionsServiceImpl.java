package com.edgardo.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edgardo.app.entity.Transactions;
import com.edgardo.app.repository.TransactionsRepository;
@Service
public class TransactionsServiceImpl implements TransactionsService {
	
	
	@Autowired
	private TransactionsRepository transactionsRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Transactions> findAll() {
	
		return transactionsRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Transactions> findAll(Pageable pageable) {
		
		return transactionsRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Transactions> findById(Long id) {
		
		return transactionsRepository.findById(id);
	}

	@Override
	@Transactional
	public Transactions save(Transactions transactions) {
	
		return transactionsRepository.save(transactions);
	}

	@Override
	public void deleById(Long id) {
		transactionsRepository.deleteById(id);
		
	}

}
