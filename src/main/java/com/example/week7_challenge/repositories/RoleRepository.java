package com.example.week7_challenge.repositories;


import com.example.week7_challenge.Controller.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long>
{
	Role findByRole(String role);
}
