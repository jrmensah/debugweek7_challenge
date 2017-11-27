package com.example.week7_challenge.DataLoader;


import com.example.week7_challenge.Controller.Role;
import com.example.week7_challenge.Controller.UserService;
import com.example.week7_challenge.repositories.RoleRepository;
import com.example.week7_challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.lang.Boolean.TRUE;

@Component
public class DataLoaders implements CommandLineRunner
{

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... strings) throws Exception
	{
		System.out.println("Loading data...");

		roleRepository.save(new Role("USER"));
		roleRepository.save(new Role("ADMIN"));

		Role adminRole = roleRepository.findByRole("ADMIN");
		Role userRole = roleRepository.findByRole("USER");


	}
}