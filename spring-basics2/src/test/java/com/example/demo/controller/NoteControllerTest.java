//package com.example.demo.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.example.demo.entity.Order;
//import com.example.demo.entity.OrderLine;
//import com.example.demo.service.NoteService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
package com.example.demo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderLine;
import com.example.demo.service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(NoteController.class)
public class NoteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NoteService noteService;

	@Autowired
	private ObjectMapper objectMapper;

	private Order testOrder;
	private OrderLine testOrderLine;

	@BeforeEach
	public void setUp() {

		testOrderLine = new OrderLine();
		testOrderLine.setId(1L);
		testOrderLine.setItem("Laptop");
		testOrderLine.setPrice(999.99);
		testOrderLine.setQuantity(1);

		testOrder = new Order();
		testOrder.setId(1L);
		testOrder.setAddress("mangalore");
		testOrder.setOrderLines(Arrays.asList(testOrderLine));
		testOrderLine.setOrder(testOrder);
	}

	@Test
	public void testGetOrderByIdForSuccessfulFetch() throws Exception {
		when(noteService.getOrderById(1L)).thenReturn(Optional.of(testOrder));
		mockMvc.perform(get("/order/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.address").value("mangalore"))
				.andExpect(jsonPath("$.orderLines[0].item").value("Laptop"))
				.andExpect(jsonPath("$.orderLines[0].price").value(999.99))
				.andExpect(jsonPath("$.orderLines[0].quantity").value(1));
		verify(noteService, times(1)).getOrderById((long) 1);
	}
	@Test
	public void testGetOrderByIdForNonExistentId() throws Exception {
		when(noteService.getOrderById(99L)).thenReturn(Optional.empty());
		mockMvc.perform(get("/order/99")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
		verify(noteService,times(1)).getOrderById(99L);			
	}
@Test
public void testGetAllOrdersForSuccessfulFetch() throws Exception {
	List<Order> orders=Arrays.asList(testOrder);
	when(noteService.getOrder()).thenReturn(orders);
	mockMvc.perform(get("/order")
	.contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk())
	.andExpect(jsonPath("$[0].address").value("mangalore"))
	.andExpect(jsonPath("$[0].orderLines[0].item").value("Laptop"))
	.andExpect(jsonPath("$[0].orderLines[0].price").value(999.99))
	.andExpect(jsonPath("$[0].orderLines[0].quantity").value(1))
	.andExpect(jsonPath("$.length()").value(1));
	verify(noteService, times(1)).getOrder();
}
@Test
void testGetOrdeForEmptyOrders() throws Exception {
when(noteService.getOrder()).thenReturn(Arrays.asList());
mockMvc.perform(get("/order")
.contentType(MediaType.APPLICATION_JSON))
.andExpect(status().isOk())
.andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(0)));
verify(noteService,times(1)).getOrder();
}
@Test
void testCreateOrderForSuccessfulCreation() throws Exception {
	when(noteService.addOrder(any(Order.class))).thenReturn(1L);
	mockMvc.perform(post("/order")
	.contentType(MediaType.APPLICATION_JSON)
	.content(objectMapper.writeValueAsString(testOrder)))
	.andExpect(status().isCreated())
	.andExpect(content().string("1"));
	verify(noteService,times(1)).addOrder(any(Order.class));
}
@Test
void testCreateOrderForMissingOrderLines() throws Exception {
Order invalid=new Order();
invalid.setOrderLines(null);
mockMvc.perform(post("/order")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(invalid)))
.andExpect(status().isBadRequest());
verify(noteService,never()).addOrder(any(Order.class));
}
}
