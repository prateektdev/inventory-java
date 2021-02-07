package com.research.inventory.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.research.inventory.model.User;
/**

* The is the User Service interface ,
* Where We declare the methods which We will be calling in the User Controller.
* The implementation of this interface is in userServiceImpl

* @version 1.0

* @author Prateek T

*/
public interface UserService {

	public Boolean save(User user);

	public List<User> getAll();

	UserDetails loadUserByUsernamePassword(String username,String password) throws UsernameNotFoundException;
}
