package com.example.demoP;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String category;
@OneToOne
@JoinColumn(name="bank_id")
private Bank bank;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Bank getBank() {
	return bank;
}
public void setBank(Bank bank) {
	this.bank = bank;
}
}
