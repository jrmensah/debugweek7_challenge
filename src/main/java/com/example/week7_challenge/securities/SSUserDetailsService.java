package com.example.week7_challenge.securities;

import com.example.week7_challenge.Controller.Role;
import com.example.week7_challenge.Controller.User;
import com.example.week7_challenge.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;

	public SSUserDetailsService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		try{

			User user = userRepository.findByUsername(username);
			if(user==null)
			{
				return null;
			}

			return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),getAuthorities(user));

		}catch (Exception e)
		{

		}
		return null;
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(Role eachRole:user.getRoles())
		{
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(eachRole.getRole());
			authorities.add(grantedAuthority);
			System.out.println("Granted Authority"+grantedAuthority.toString());
		}
		return authorities;
	}
}