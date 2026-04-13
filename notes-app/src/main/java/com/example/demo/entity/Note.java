package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class Note {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private long id;
@NotBlank
private String title;
@NotBlank
private String content;
@NotNull(message="Date is required")
private Date dateTime;
@Min(0)
@Max(10)
private int priority;
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
	CLOSED
}
public int getPriority() {
	return priority;
}
public void setPriority(int priority) {
	this.priority = priority;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getDateTime() {
	return dateTime;
}
public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
}

}

