package com.example.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderLine;
import com.example.demo.repository.Order1Repository;

@Service
public class NoteService {
	@Autowired
	Order1Repository order1Repository;

	@Autowired
	EmailService emailService;
	@Autowired
	PaymentService paymentService;

	public Iterable<Order> getOrder() {
		return order1Repository.findAll();
	}

	public Optional<Order> getOrderById(Long id) {
		return order1Repository.findById(id);
	}

	public void deleteOrderById(Long id) {
		order1Repository.deleteById(id);
		;
	}

	@Transactional(rollbackFor = Exception.class, noRollbackFor = { IOException.class })
//	public Long addOrder(Order order) throws IOException {
//		//paymentService.processPayment();
//		order1Repository.save(order);
//		//emailService.send(order1.getId());
//		return order.getId();
	public Long addOrder(Order order) {
		if (order.getOrderLines() == null || order.getOrderLines().isEmpty()) {
			throw new IllegalArgumentException("Order must have at least one order line");
		}
		order.setCreatedAt(LocalDateTime.now());
		order.setStatus(Order.Status.CREATED);
		for (OrderLine line : order.getOrderLines()) {
			if (line.getItem() == null || line.getItem().trim().isEmpty()) {
				throw new IllegalArgumentException("Item name cannot be null or empty");
			}
			line.setOrder(order);
		}

		order1Repository.save(order);

		return order.getId();
	}
}
