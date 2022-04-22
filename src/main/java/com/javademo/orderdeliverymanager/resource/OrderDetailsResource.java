package com.javademo.orderdeliverymanager.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javademo.orderdeliverymanager.model.OrderDetails;
import com.javademo.orderdeliverymanager.service.OrderDetailsService;

@RestController
@RequestMapping("/orders")
public class OrderDetailsResource {

	private final OrderDetailsService orderDetailsService;

	public OrderDetailsResource(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}

	@PostMapping("/add")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails orderDetails) {
		OrderDetails newOrderDetails = orderDetailsService.addOrder(orderDetails);
		return new ResponseEntity<>(newOrderDetails, HttpStatus.CREATED);
	}

	@GetMapping("/count")
	public ResponseEntity<Long> getOrdersCount() {
		Long ordersCount = orderDetailsService.getOrderCount();
		return new ResponseEntity<>(ordersCount, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<OrderDetails>> getAllOrders() {
		List<OrderDetails> ordersList = orderDetailsService.findAllOrderDetails();
		return new ResponseEntity<>(ordersList, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOrderById(@PathVariable Long id) {
		orderDetailsService.deleteOrderById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
