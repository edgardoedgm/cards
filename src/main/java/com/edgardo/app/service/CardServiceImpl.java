package com.edgardo.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edgardo.app.entity.Card;
import com.edgardo.app.entity.TypeCard;
import com.edgardo.app.entity.CardIdDto;
import com.edgardo.app.repository.CardRepository;
import com.edgardo.app.repository.TypeCardRepository;

@Service
public class CardServiceImpl implements CardService {
	private String aleatorio = null;
	private int ramdom = 0;

	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private TypeCardRepository typecardRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Card> findAll() {

		return cardRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Card> findAll(Pageable pageable) {

		return cardRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Card> findById(Long id) {

		return cardRepository.findById(id);
	}

	@Override
	@Transactional
	public Card save(Card card) {

		return cardRepository.save(card);
	}

	@Override
	@Transactional
	public void deleById(Long id) {

		cardRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleByNumber(String number) {

		cardRepository.deleteByNumber(number);
	}

	@Override

	public String accountNumber(Long productid) {
		String acum = "";
		for (int i = 0; i < 9; i++) {
			ramdom = (int) (Math.random() * 10 + 1);
			acum += ramdom;
		}
		aleatorio = productid + acum;

		return aleatorio;
	}

	@Override

	public Date expiryDate() {
		long treeYears = 94672800000L;
		long miliseconds = System.currentTimeMillis() + treeYears;
		Date date = new Date(miliseconds);

		return date;
	}

	@Override

	public Optional<Card> findByNumber(String number) {

		return cardRepository.findByNumber(number);
	}

}
