package com.javademo.orderdeliverymanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javademo.orderdeliverymanager.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);
}
