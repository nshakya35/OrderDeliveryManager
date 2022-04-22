package com.javademo.orderdeliverymanager.model;

import java.util.Date;

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
public class OrderDetails {

	@Id
	@GeneratedValue
	private Long id;
	private Date orderDate;
	private String productName;
	private int quantity;
	private double price;
	private double totalPrice;

}
