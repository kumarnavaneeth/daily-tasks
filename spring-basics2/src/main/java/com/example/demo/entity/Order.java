package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="Orders")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private LocalDateTime createdAt;
@NotBlank
private String address;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Enumerated(EnumType.STRING)
private Status status;
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public enum Status{
	CREATED,
	INTRANSIT,
	COMPLETED
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public List<OrderLine> getOrderLines() {
	return orderLines;
}
public void setOrderLines(List<OrderLine> orderLines) {
	this.orderLines = orderLines;
}
@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonManagedReference
private List<OrderLine> orderLines = new ArrayList<>();
public void addOrderLine(OrderLine line) {
	orderLines.add(line);
	line.setOrder(this);
}
}
