package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderLine;
import com.example.demo.repository.Order1Repository;

class NotesServiceTest {

	@InjectMocks
	NoteService notesService;
	@Mock
	Order1Repository order1Repository;
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void TestSuccessfulAddOrder() {
		Order order=new Order();
	    OrderLine orderLine = new OrderLine();
	    orderLine.setItem("Laptop");
	    orderLine.setPrice(50000);
	    List<OrderLine> lines=new ArrayList<>();
	    lines.add(orderLine);
	    order.setOrderLines(lines);
	    order.setId(1L);
	    when(order1Repository.save(any(Order.class))).thenReturn(order);
	    Long result=notesService.addOrder(order);
	    assertNotNull(result);
	    assertEquals(result,1L );
	}	
	@Test
	void testAddOrderStatusCreated() {
	    Order order = new Order();
	    OrderLine line = new OrderLine();
	    line.setItem("Laptop");
	    line.setPrice(50000);
	    List<OrderLine> lines = new ArrayList<>();
	    lines.add(line);
	    order.setOrderLines(lines);
	    when(order1Repository.save(any(Order.class))).thenReturn(order);
	    notesService.addOrder(order);
	    assertEquals(Order.Status.CREATED, order.getStatus());
	}
	@Test
	void testEmptyOrderLines() {
	    Order order = new Order();
	    order.setOrderLines(new ArrayList<>());
	    when(order1Repository.save(any(Order.class))).thenReturn(order);
	    assertThrows(IllegalArgumentException.class,
	            () -> notesService.addOrder(order));
	}
	@Test
	void testNUllOrderLines() {
	    Order order = new Order();
	    order.setOrderLines(null);
	    when(order1Repository.save(any(Order.class))).thenReturn(order);
	    assertThrows(IllegalArgumentException.class,
	            () -> notesService.addOrder(order));
	}
}
