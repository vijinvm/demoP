package com.example.demoP;
import jakarta.persistence.*;
@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String product;
@OneToOne(mappedBy="bank")
private Person person;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
}
