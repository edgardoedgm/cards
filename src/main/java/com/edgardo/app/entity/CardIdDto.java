package com.edgardo.app.entity;

import org.springframework.stereotype.Repository;


@Repository
public class CardIdDto {
	
	private String cardId;
	
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	

}
