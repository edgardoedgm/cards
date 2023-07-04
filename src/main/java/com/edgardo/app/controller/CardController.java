package com.edgardo.app.controller;

import java.time.Instant;
import java.util.*;

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

import com.edgardo.app.entity.Active;
import com.edgardo.app.entity.Card;
import com.edgardo.app.entity.TypeCard;
import com.edgardo.app.entity.CardIdDto;
import com.edgardo.app.entity.PurchaseDto;
import com.edgardo.app.entity.Transactions;
import com.edgardo.app.entity.User;
import com.edgardo.app.service.CardService;
import com.edgardo.app.service.TransactionsService;
import com.edgardo.app.service.TypeCardService;

@RestController
@RequestMapping("/api/card")
public class CardController {

	@Autowired
	private CardService cardService;
	
	@Autowired
	private TransactionsService transactionsService; 

	// Create Cards

	@GetMapping("/{productid}")
	public ResponseEntity<?> accountProcess(@PathVariable(value = "productid") Long productId) {

		if (productId != null) {

			Card card = new Card();

			card.setNumber(cardService.accountNumber(productId));
			card.setDataExpiry(cardService.expiryDate());
			card.setTypecard("savingsAccount");
			card.setUser("anonymous");
			card.setBalance(0.0);
			card.setStatus("disabled");
			card.setCurrency("dollar");

			return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(card));

		}

		return ResponseEntity.notFound().build();
	}

	// Active Card
	@PostMapping("/enroll")
	public ResponseEntity<?> active(@RequestBody Card card) {

		Optional<Card> card1 = cardService.findByNumber(card.getNumber());

		card1.get().setStatus("enable");

		return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(card1.get()));
	}

	// Delete an card

	@DeleteMapping("/{number}")
	public ResponseEntity<?> delete(@PathVariable(value = "number") String number) {

		if (!cardService.findByNumber(number).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cardService.deleByNumber(number);
		return ResponseEntity.ok().build();

	}

	// Active balance
	@PostMapping("/balance")
	public ResponseEntity<?> balance(@RequestBody Card card) {

		Optional<Card> card1 = cardService.findByNumber(card.getNumber());

		card1.get().setBalance(card.getBalance());

		return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(card1.get()));
	}

	// Query Balance

	@GetMapping("/balance/{cardid}")
	public ResponseEntity<?> balanceQuery(@PathVariable(value = "cardid") String cardid) {

		Optional<Card> card1 = cardService.findByNumber(cardid);

		return ResponseEntity.status(HttpStatus.OK).body(card1);

	}
	
	// create Transactions
	@PostMapping("/transaction/purchase")
	public ResponseEntity<?> purchase(@RequestBody Transactions transactions) {

		if (cardService.findByNumber(transactions.getCardId()).isPresent()) {
			transactionsService.save(transactions);
			return ResponseEntity.status(HttpStatus.OK).build();
		}

		return ResponseEntity.notFound().build();
	}
	
	// Query Transactions
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<?> transactionsQuery(@PathVariable(value = "transactionId") Long transactionId) {

		Optional<Transactions> transaction = transactionsService.findById(transactionId);

		return ResponseEntity.status(HttpStatus.OK).body(transaction);

	}
	
	
	
	
	
	

}
