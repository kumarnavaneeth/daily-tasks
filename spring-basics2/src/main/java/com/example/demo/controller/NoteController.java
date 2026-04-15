package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.entity.Order1;
import com.example.demo.service.NoteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class NoteController {
	@Autowired
	NoteService noteService;
	@GetMapping
	Iterable<Order> getOrder() {
		return noteService.getOrder();
	}
	@GetMapping("/{id}")
	Optional<Order> getOrderById(@PathVariable Long id) {
		return noteService.getOrderById(id);
	}

	@DeleteMapping("/{id}")
	void deleteOrderById(@PathVariable Long id) {
		noteService.deleteOrderById(id);
	}

	@PostMapping
	Long createOrder(@RequestBody @Valid Order order) throws IOException {
		return noteService.addOrder(order);
	}
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		return " something went wrong, please retry";
	}

}
