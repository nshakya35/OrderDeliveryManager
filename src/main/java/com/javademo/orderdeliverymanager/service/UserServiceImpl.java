package com.javademo.orderdeliverymanager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javademo.orderdeliverymanager.model.Role;
import com.javademo.orderdeliverymanager.model.Users;
import com.javademo.orderdeliverymanager.repo.RoleRepository;
import com.javademo.orderdeliverymanager.repo.UsersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UsersRepository userRepo;

	private final RoleRepository roleRepo;

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users appUser = userRepo.findByUsername(username);
		if (appUser == null) {
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		} else {
			log.info("User found in the database: {}", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		appUser.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(),
				authorities);
	}

	@Override
	public Users saveUser(Users appUser) {
		log.info("Saving new user to the database");
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
		return userRepo.save(appUser);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role to the database");
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Adding role to the user in the database");
		Users appUser = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		appUser.getRoles().add(role);

	}

	@Override
	public Users getUser(String username) {
		log.info("Fetching user from the database");
		return userRepo.findByUsername(username);
	}

	@Override
	public List<Users> getUsers() {
		log.info("Fetching all users");
		return userRepo.findAll();
	}
}
