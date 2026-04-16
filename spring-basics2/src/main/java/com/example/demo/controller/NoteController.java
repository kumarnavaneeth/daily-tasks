package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import org.springframework.web.server.ResponseStatusException;

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
	@ResponseStatus(HttpStatus.OK)
	Iterable<Order> getOrder() {
		return noteService.getOrder();
	}
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	Order getOrderById(@PathVariable Long id) {
		return noteService.getOrderById(id).orElseThrow(()->new
				ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteOrderById(@PathVariable Long id) {
		noteService.deleteOrderById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
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

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		return " something went wrong, please retry";
	}

}
