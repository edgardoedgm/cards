package com.edgardo.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.edgardo.app.entity.TypeCard;
import com.edgardo.app.repository.TypeCardRepository;

public class TypeCardServiceImpl implements TypeCardService {
	
	
	@Autowired
	private TypeCardRepository typeCardRepository;
	

	@Override
	@Transactional(readOnly=true)
	public Optional<TypeCard> findById(Long id) {
	
		return typeCardRepository.findById(id);
	}

}
