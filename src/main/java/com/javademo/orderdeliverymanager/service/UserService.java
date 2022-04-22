package com.javademo.orderdeliverymanager.service;

import java.util.List;

import com.javademo.orderdeliverymanager.model.Role;
import com.javademo.orderdeliverymanager.model.Users;

public interface UserService {

	Users saveUser(Users appUser);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	Users getUser(String username);

	List<Users> getUsers();
}
