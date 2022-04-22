package com.javademo.orderdeliverymanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javademo.orderdeliverymanager.model.Payment;
import com.javademo.orderdeliverymanager.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

	@Autowired
	private final PaymentService paymentService;

	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

//	@PostMapping("/add")
//	public Payment makePayment(@RequestBody OrderDetails orderDetails) {
//		return paymentService.makePayment(orderDetails);
//	}

	@PostMapping("/add/{id}")
	public ResponseEntity<Payment> makePayment(@PathVariable Long id) {
		Payment payment = paymentService.makePayment(id);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Long> getTotalNumberOfPayments() {
		Long paymetCount = paymentService.getTotalPaymentCount();
		return new ResponseEntity<>(paymetCount, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Payment>> getAllPayments() {
		List<Payment> paymentList = paymentService.getAllPayments();
		return new ResponseEntity<>(paymentList, HttpStatus.OK);
	}

}
