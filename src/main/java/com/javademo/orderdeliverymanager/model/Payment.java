package com.javademo.orderdeliverymanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue
	private Long paymentId;
	private String paymentStatus;
	private String transactionId;
	private Long orderId;
	private String productName;
	private int quantity;
	private double amount;

}
