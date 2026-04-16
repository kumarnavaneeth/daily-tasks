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
	    orderLine.setQuantity(2);
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
	void testAddOrderWithMissingItem() {
		Order order = new Order();
		OrderLine orderLine = new OrderLine();
		orderLine.setPrice(100);
		orderLine.setQuantity(3);
		orderLine.setItem("");
		List<OrderLine> lines = new ArrayList<>();
		lines.add(orderLine);
		order.setOrderLines(lines);
		assertThrows(IllegalArgumentException.class, () -> {
			notesService.addOrder(order);
		});
		verify(order1Repository, never()).save(any(Order.class));
	}
	@Test
	void testaddOrderWithNegativePrice() {
		Order order=new Order();
		OrderLine orderLine=new OrderLine();
		orderLine.setItem("box");
		orderLine.setPrice(-2);
		orderLine.setQuantity(2);
		List<OrderLine> lines=new ArrayList<>();
		lines.add(orderLine);
		order.setOrderLines(lines);
		assertThrows(IllegalArgumentException.class,()->{
			notesService.addOrder(order);
		});
		verify(order1Repository, never()).save(any(Order.class));
	}
	@Test
	void testaddOrderWithNoQuantity() {
		Order order=new Order();
		OrderLine orderLine=new OrderLine();
		orderLine.setItem("box");
		orderLine.setPrice(-2);
		orderLine.setQuantity(2);
		List<OrderLine> lines=new ArrayList<>();
		lines.add(orderLine);
		order.setOrderLines(lines);
		assertThrows(IllegalArgumentException.class,()->{
			notesService.addOrder(order);
		});
		verify(order1Repository, never()).save(any(Order.class));
	}
	@Test
	void testADDOrderWithZeroOrderLines() {
		Order order=new Order();
		List<OrderLine> lines=new ArrayList<>();
		order.setOrderLines(lines);
		assertThrows(IllegalArgumentException.class,()->{
			notesService.addOrder(order);
		});
		verify(order1Repository, never()).save(any(Order.class));
	}
}
