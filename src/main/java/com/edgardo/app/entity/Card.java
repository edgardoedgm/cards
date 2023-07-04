package com.edgardo.app.entity;

import java.io.Serializable;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "cards")
public class Card implements Serializable {


	private static final long serialVersionUID = -2873500861367429972L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// 6 primero del id y el restanto aleatorios
	@Column(length=100, nullable=false, unique=true)
	private String number;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDataExpiry() {
		return dataExpiry;
	}
	public void setDataExpiry(Date dataExpiry) {
		this.dataExpiry = dataExpiry;
	}
	public String getTypecard() {
		return typecard;
	}
	public void setTypecard(String typecard) {
		this.typecard = typecard;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataExpiry;
	@Column(length=16)
	private String typecard;
	@Column(length=16)
	private String user;
	
	@Column(length=16)
	private Double balance;
	@Column(length=16)
	private String status;
	@Column(length=16)
	private String currency;

	/*public Card(String number, Date dataExpiry, String typecard, String user, Double balance, String status,
			String currency) {
		super();
		this.number = number;
		this.dataExpiry = dataExpiry;
		this.typecard = typecard;
		this.user = user;
		this.balance = balance;
		this.status = status;
		this.currency = currency;
	}*/



	

	
	
	

}
