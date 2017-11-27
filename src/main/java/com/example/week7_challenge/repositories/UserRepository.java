package com.example.week7_challenge.repositories;


import com.example.week7_challenge.Controller.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
	User findByUsername(String username);
	User findByemail(String email);
	Long countByEmail(String email);
	Long countByusername(String username);
}
