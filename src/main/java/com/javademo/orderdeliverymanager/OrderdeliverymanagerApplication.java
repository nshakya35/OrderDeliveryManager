package com.javademo.orderdeliverymanager;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.javademo.orderdeliverymanager.model.Role;
import com.javademo.orderdeliverymanager.model.Users;
import com.javademo.orderdeliverymanager.service.UserService;

@SpringBootApplication
public class OrderdeliverymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderdeliverymanagerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new Users(null, "John lama", "john", "1234", new ArrayList<>()));
//			userService.saveUser(new Users(null, "Ram lama", "ram", "1234", new ArrayList<>()));
//			userService.saveUser(new Users(null, "Sujan lama", "sujan", "1234", new ArrayList<>()));
//			userService.saveUser(new Users(null, "Hari lama", "hari", "1234", new ArrayList<>()));
//
//			userService.addRoleToUser("john", "ROLE_USER");
//			userService.addRoleToUser("john", "ROLE_MANAGER");
//			userService.addRoleToUser("ram", "ROLE_MANAGER");
//			userService.addRoleToUser("sujan", "ROLE_ADMIN");
//			userService.addRoleToUser("hari", "ROLE_USER");
//			userService.addRoleToUser("hari", "ROLE_ADMIN");
//			userService.addRoleToUser("hari", "ROLE_SUPER_ADMIN");
//		};
//	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
