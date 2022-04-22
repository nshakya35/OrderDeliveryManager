package com.javademo.orderdeliverymanager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javademo.orderdeliverymanager.model.OrderDetails;
import com.javademo.orderdeliverymanager.model.Payment;
import com.javademo.orderdeliverymanager.repo.OrderDetailsRepository;

@Service
public class OrderDetailsService {

	@Autowired
	private final OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private final PaymentService paymentService;

	public OrderDetailsService(OrderDetailsRepository orderDetailsRepository, PaymentService paymentService) {
		super();
		this.orderDetailsRepository = orderDetailsRepository;
		this.paymentService = paymentService;
	}

	public OrderDetails addOrder(OrderDetails orderDetails) {
		orderDetails.setOrderDate(new Date());
		orderDetails.setTotalPrice(orderDetails.getQuantity() * orderDetails.getPrice());
		return orderDetailsRepository.save(orderDetails);
//		Payment payment = new Payment();
//		payment.setAmount(orderDetails.getPrice() * orderDetails.getQuantity());
//		payment.setOrderId(orderDetails.getId());
//		paymentService.makePayment(payment);
//		return orderDetails;
	}

	public List<OrderDetails> findAllOrderDetails() {
		return orderDetailsRepository.findAll();
	}

	public Long getOrderCount() {
		return orderDetailsRepository.count();
	}

	public void deleteOrderById(Long id) {
		orderDetailsRepository.deleteById(id);
	}

}
