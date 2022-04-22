package com.javademo.orderdeliverymanager.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.javademo.orderdeliverymanager.model.OrderDetails;
import com.javademo.orderdeliverymanager.model.Payment;
import com.javademo.orderdeliverymanager.repo.OrderDetailsRepository;
import com.javademo.orderdeliverymanager.repo.PaymentRepository;

@Service
public class PaymentService {

	private static final String PENDING_IDENTIFIER = "pending";

	private static final String SUCCESS_IDENTIFIER = "success";

	private final PaymentRepository paymentRepository;

	private final OrderDetailsRepository orderDetailsRepository;

	public PaymentService(PaymentRepository paymentRepository, OrderDetailsRepository orderDetailsRepository) {
		super();
		this.paymentRepository = paymentRepository;
		this.orderDetailsRepository = orderDetailsRepository;
	}

	public Payment makePayment(Payment payment) {
		payment.setPaymentStatus(getPaymentStatus());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	public Payment makePayment(OrderDetails orderDetails) {
		Payment payment = new Payment();
		payment.setAmount(orderDetails.getPrice() * orderDetails.getQuantity());
		payment.setOrderId(orderDetails.getId());
		return makePayment(payment);
	}

	public Payment makePayment(Long orderId) {
		Payment payment = new Payment();
		OrderDetails orderDetails = orderDetailsRepository.findById(orderId).orElse(null);
		if (orderDetails != null) {
			payment.setAmount(orderDetails.getPrice() * orderDetails.getQuantity());
			payment.setOrderId(orderDetails.getId());
			payment.setProductName(orderDetails.getProductName());
			payment.setQuantity(orderDetails.getQuantity());
		}
		return makePayment(payment);
	}

	private String getPaymentStatus() {
		return new Random().nextBoolean() ? SUCCESS_IDENTIFIER : PENDING_IDENTIFIER;
	}

	public Long getTotalPaymentCount() {
		return paymentRepository.count();
	}

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

}
