package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
@Entity
public class OrderLine {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
private String item;
private double price;
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}

@ManyToOne
@JoinColumn(name="order_id")
@JsonBackReference 
private Order order;
}
