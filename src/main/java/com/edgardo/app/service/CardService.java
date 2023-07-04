package com.edgardo.app.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edgardo.app.entity.Card;
import com.edgardo.app.entity.TypeCard;
import com.edgardo.app.entity.CardIdDto;

public interface CardService {
	
	
	public Iterable <Card> findAll();
	public Page<Card> findAll(Pageable pageable);
	public Optional<Card> findById(Long id);
	public Card save(Card card);
	public void deleById(Long id);
	public String accountNumber(Long productid);
	public Date expiryDate();
	public Optional<Card> findByNumber(String number);
	public void deleByNumber(String number);

}
