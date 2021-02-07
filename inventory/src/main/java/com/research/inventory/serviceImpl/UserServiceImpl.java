package com.research.inventory.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.research.inventory.model.Role;
import com.research.inventory.model.User ;
import com.research.inventory.repository.UserRepository;
import com.research.inventory.service.UserService;
/**

* The is the User Service implementation ,
* Where We defined the methods which are declared in the user service

* @version 1.0

* @author Prateek T

*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;


	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * The method is used for creating user object
	 * takes user object  and returns true if saved else false
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public Boolean save(User user) {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * The method is used for fetching user object by its username and password
	 * takes username and password as string  and returns Spring securioty userDetails object for it
	 * @version 1.0
	 * @author Prateek T
	 */
	@Override
	public UserDetails loadUserByUsernamePassword(String username,String password) throws UsernameNotFoundException {
		User applicationUser = userRepository.findByUsername(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		} 
		if(!bCryptPasswordEncoder.matches(password, applicationUser.getPassword())){
			return null ;
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList()  ;
	    grantedAuthorities.add(new SimpleGrantedAuthority(applicationUser.getRole().toString())) ;
		return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(),grantedAuthorities);
	}
	/**
	 * The method is used for fetching user objects 
	 * takes nothing and returns all user objects 
	 * @version 1.0
	 * @author Prateek T
	 */
	public List<User> getAll() {
		List<User> users = (List<User>) userRepository.findAll() ;
		return users.stream().filter(user->user.getRole()!=Role.ROLE_ADMIN).collect(Collectors.toList());
	}

}
