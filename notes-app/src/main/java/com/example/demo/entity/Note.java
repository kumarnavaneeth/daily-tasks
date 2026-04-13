package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;

public class Note {
long id;
@NotBlank
String title;
@NotBlank
String content;
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

}

