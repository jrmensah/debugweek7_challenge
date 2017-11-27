package com.example.week7_challenge.Controller;

//import com.example.week7_challenge.repositories.JobSeekerRepository;
import com.example.week7_challenge.repositories.JobSeekerRepository;
import com.example.week7_challenge.repositories.RoleRepository;
import com.example.week7_challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	JobSeekerRepository jobSeekerRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {
		return this.userRepository.findByemail(email);
	}

	public Long countByEmail(String email) {
		return this.userRepository.countByEmail(email);
	}

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	public void saveUser(User user) {
		user.setRoles(Arrays.asList(this.roleRepository.findByRole("USER")));
		user.setEnabled(true);
		this.userRepository.save(user);
	}

	public void saveAdmin(User user) {
		user.setRoles(Arrays.asList(this.roleRepository.findByRole("ADMIN")));
		user.setEnabled(true);
		this.userRepository.save(user);
	}
}