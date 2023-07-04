package com.edgardo.app.service;

import java.util.Optional;



import com.edgardo.app.entity.TypeCard;

public interface TypeCardService {
	

	public Optional<TypeCard> findById(Long id);


}
