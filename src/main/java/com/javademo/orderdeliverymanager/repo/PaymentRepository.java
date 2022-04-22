package com.javademo.orderdeliverymanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javademo.orderdeliverymanager.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
