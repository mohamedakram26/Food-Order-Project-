package com.project.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Order;
import com.project.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	

//adding order details
	@PostMapping("{customerId}/{cartId}")
	public ResponseEntity<Order> addOrder( @PathVariable long customerId,@PathVariable long cartId, @RequestBody Order order) {

		return new ResponseEntity<Order>(orderService.addOrder(order,customerId,cartId),
				HttpStatus.CREATED);
	}

//updating order details
	@PutMapping("{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable("orderId") long orderId, @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.updateOrder(order, orderId), HttpStatus.OK);
	}

	// get all order details
	@GetMapping()
	public List<Order> getAllOrders() {

		return orderService.getAllOrders();
	}

	// get order details by customer id
	@GetMapping("{customerId}")
	public List<Order> getOrderByCustomerId(@PathVariable long customerId) {
		return orderService.getOrderByCustomerId(customerId);
	}


	// to delete or cancel Order
	@DeleteMapping("{orderId}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable("orderId") long orderId) {
		orderService.deleteOrder(orderId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

}
