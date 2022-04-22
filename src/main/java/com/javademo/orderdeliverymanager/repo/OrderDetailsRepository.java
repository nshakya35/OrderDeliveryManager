package com.javademo.orderdeliverymanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javademo.orderdeliverymanager.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
