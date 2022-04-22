package com.javademo.orderdeliverymanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javademo.orderdeliverymanager.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
